package com.mygdx.panda3.stages;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.Contact;
import com.badlogic.gdx.physics.box2d.ContactImpulse;
import com.badlogic.gdx.physics.box2d.ContactListener;
import com.badlogic.gdx.physics.box2d.Manifold;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.Stage;

import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.mygdx.panda3.actors.HealthBar;
import com.mygdx.panda3.actors.Obstacle;
import com.mygdx.panda3.actors.Panda;
import com.mygdx.panda3.actors.BackgroundActor;
import com.mygdx.panda3.actors.PauseButton;
import com.mygdx.panda3.actors.PowerUp;
import com.mygdx.panda3.actors.Score;
import com.mygdx.panda3.box2d.ObstacleUserData;
import com.mygdx.panda3.box2d.PowerUpUserData;
import com.mygdx.panda3.enums.GameStageState;
import com.mygdx.panda3.screens.GameScreen;
import com.mygdx.panda3.utils.BodyUtils;
import com.mygdx.panda3.utils.RandomUtils;
import com.mygdx.panda3.utils.TextureUtils;
import com.mygdx.panda3.utils.WorldUtils;
import com.mygdx.panda3.utils.Constants;

public class GameStage extends Stage implements ContactListener {
    private World world;
    private GameScreen parent;

    private TextureAtlas textureAtlas;
    private BitmapFont font;

    private float accumulator = 0f;
    private float rowTime = 0f;
    private GameStageState gameState;

    private OrthographicCamera camera;
    private Box2DDebugRenderer renderer;

    private Rectangle screenRightSide;
    private Rectangle screenLeftSide;

    private Vector3 touchPoint;

    private Panda panda;
    private HealthBar healthBar;
    private Score score;
    private PauseButton pauseButton;
    private BackgroundActor sideBounds;
    private BackgroundActor background;

    private Group obstacles;

    public GameStage(GameScreen parent, Viewport viewport, AssetManager assets){
        super(viewport);
        this.parent = parent;
        this.textureAtlas = assets.get(Constants.TEXTURE_ATLAS_FILENAME, TextureAtlas.class);
        this.font = assets.get(Constants.MEDIUM_FONT_NAME, BitmapFont.class);

        setupCamera();
        setupWorld();
        setupTouchAreas();

        renderer = new Box2DDebugRenderer();
    }

    public void restart(){
        this.clear();
        setupWorld();
    }

    private void setupWorld(){
        world = WorldUtils.createWorld();
        world.setContactListener(this);

        setupBackground();
        setupPanda();

        obstacles = new Group();
        this.addActor(obstacles);

        setupBounds();
        setupHealthBar();
        setupScore();
        setupPauseButton();

        gameState = GameStageState.RUNNING;
    }

    private void setupHealthBar(){
        healthBar = new HealthBar(textureAtlas.findRegion(Constants.HEALTH_BAR_TEXTURE_NAME), Constants.STARTING_HEALTH);
        this.addActor(healthBar);
    }

    private void setupCamera(){
        camera = new OrthographicCamera(Constants.APP_WIDTH, Constants.APP_HEIGHT);
        camera.position.set(camera.viewportWidth / 2, camera.viewportHeight / 2, 0f);
        camera.update();
    }
    private void setupPanda(){
        panda = new Panda(  WorldUtils.createPandaBody(world),
                            textureAtlas.findRegion(Constants.PANDA_TEXTURE_NAME),
                            TextureUtils.createFireAnimation(textureAtlas));
        this.addActor(panda);
    }

     private void setupBounds(){
        sideBounds = new BackgroundActor(WorldUtils.createSideBoundsBody(world), textureAtlas.findRegion("background_leaves"), Constants.BACKGROUND_LEAVES_SPEED);
        this.addActor(sideBounds);
     }

     private void setupBackground(){
        background = new BackgroundActor(WorldUtils.createSideBoundsBody(world), textureAtlas.findRegion("background"), Constants.BACKGROUND_SPEED);
        this.addActor(background);
     }

     private void setupScore(){
        score = new Score(font);
        score.start();
        this.addActor(score);
     }

     private void setupPauseButton(){
        pauseButton = new PauseButton(textureAtlas.findRegion(Constants.PAUSE_BUTTON_TEXTURE_NAME));
        this.addActor(pauseButton.getButton());

     }

     private void setupTouchAreas(){
        touchPoint = new Vector3();
        screenLeftSide = new Rectangle(0, 0,
                                getCamera().viewportWidth / 2, getCamera().viewportHeight - Constants.GAME_STAGE_UI_HEIGHT);
        screenRightSide = new Rectangle(getCamera().viewportWidth / 2, 0,
                                    getCamera().viewportHeight / 2, getCamera().viewportHeight - Constants.GAME_STAGE_UI_HEIGHT);
        Gdx.input.setInputProcessor(this);
     }

    @Override
    public void act(float delta){
        if(gameState == GameStageState.PAUSED || gameState == GameStageState.ENDED){
            delta = 0f;
        }

        super.act(delta);

        Array<Body> bodies = new Array<Body>(world.getBodyCount());
        world.getBodies(bodies);

        for(Body body: bodies){
            update(body);
        }

        // Fixed interval
        accumulator += delta;

        while(accumulator >= delta){
            world.step(Constants.TIME_STEP, 6, 2);
            accumulator -= Constants.TIME_STEP;
        }

        // Spawn obstacles
        if(rowTime >= Constants.OBSTACLE_SPAWN_DELAY){
            rowTime = 0f;
            float a = RandomUtils.randomFloat();
            if(a > 0.1f){
                createObstacle();
            }
            else{
                createPowerUp();
            }
        }
        else{
            rowTime += delta;
        }

        // Here interpolation would happen if we implemented one
    }

    private void update(Body body){
        if(!BodyUtils.bodyInBounds(body) || !body.isActive()){
            removeBody(body);
        }
    }

    private void removeBody(Body body){
        body.setUserData(null);
        world.destroyBody(body);
    }

    private void createObstacle(){
        Body powerUpBody = WorldUtils.createObstacle(world);
        ObstacleUserData obstacleUserData = (ObstacleUserData) powerUpBody.getUserData();
        TextureRegion obstacleTextureRegion = textureAtlas.findRegion(obstacleUserData.getTextureName());
        obstacles.addActor(new Obstacle(powerUpBody, obstacleTextureRegion));
    }

    private void createPowerUp(){
        Body obstacleBody = WorldUtils.createPowerUp(world);
        PowerUpUserData powerUpUserData = (PowerUpUserData) obstacleBody.getUserData();
        TextureRegion obstacleTextureRegion = textureAtlas.findRegion(powerUpUserData.getTextureName());
        obstacles.addActor(new PowerUp(obstacleBody, obstacleTextureRegion));
    }

    @Override
    public void draw(){
        super.draw();
        renderer.render(world, camera.combined);
    }

    @Override
    public boolean touchDown(int x, int y, int pointer, int button){
        translateScreenToWorldCoordinates(x, y);

        if(rightSideTouched(touchPoint.x, touchPoint.y)){
            panda.moveRight();
        }
        else if(leftSideTouched(touchPoint.x, touchPoint.y)){
            panda.moveLeft();
        }

        return super.touchDown(x, y, pointer, button);
    }

    @Override
    public boolean touchUp(int x, int y, int pointer, int button){
        panda.stop();

        return super.touchUp(x, y, pointer, button);
    }

    private boolean rightSideTouched(float x, float y){
        return screenRightSide.contains(x, y);
    }

    private boolean leftSideTouched(float x, float y){
        return screenLeftSide.contains(x, y);
    }


    private void translateScreenToWorldCoordinates(int x, int y){
        getCamera().unproject(touchPoint.set(x, y, 0));
    }

    private void gameOver(){
        gameState = GameStageState.ENDED;
        parent.gameover(score.getScore());
    }

    public GameScreen getParentScreen(){
        return parent;
    }

    @Override
    public void beginContact(Contact contact){
    }
    @Override
    public void endContact(Contact contact) {
    }

    @Override
    public void preSolve(Contact contact, Manifold oldManifold) {
        Body a = contact.getFixtureA().getBody();
        Body b = contact.getFixtureB().getBody();

        if ((BodyUtils.bodyIsPanda(a) && BodyUtils.bodyIsObstacle(b)) ||
                (BodyUtils.bodyIsObstacle(a) && BodyUtils.bodyIsPanda(b))) {
            contact.setEnabled(false);
            if(!panda.isInvulnerable()){
                if(healthBar.getHealth() > 1){
                    panda.hit();
                    healthBar.decrease();
                }
                else{
                    healthBar.decrease();
                    gameOver();
                }
            }
        }

        if(BodyUtils.bodyIsPanda(a) && BodyUtils.bodyIsPowerUp(b)){
            contact.setEnabled(false);
            pandaPowerUpPreContact(b);
        }
        else if(BodyUtils.bodyIsPowerUp(a) && BodyUtils.bodyIsPanda(b)){
            contact.setEnabled(false);
            pandaPowerUpPreContact(a);
        }
    }

    private void pandaPowerUpPreContact(Body powerUpBody){
        PowerUpUserData userData = (PowerUpUserData) powerUpBody.getUserData();
        try {
            Action action = userData.getPowerUpClass().newInstance();
            panda.addAction(action);
        }
        catch(Exception e){
            Gdx.app.log("CRITICAL ERROR" , "Couldn't instantiate PowerUp action.");
        }
        powerUpBody.setActive(false);
    }

    @Override
    public void postSolve(Contact contact, ContactImpulse impulse) {
    }

    public GameStageState getGameState() {
        return gameState;
    }

    public void setGameState(GameStageState state) {
        this.gameState = state;
    }

}
