package com.mygdx.panda3.stages;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.OrthographicCamera;
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
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.Stage;

import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.mygdx.panda3.actors.Obstacle;
import com.mygdx.panda3.actors.Panda;
import com.mygdx.panda3.actors.BackgroundActor;
import com.mygdx.panda3.box2d.ObstacleUserData;
import com.mygdx.panda3.utils.BodyUtils;
import com.mygdx.panda3.utils.WorldUtils;
import com.mygdx.panda3.utils.Constants;

public class GameStage extends Stage implements ContactListener {
    private World world;
    private Game game;

    private TextureAtlas textureAtlas;

    private float accumulator = 0f;

    private OrthographicCamera camera;
    private Box2DDebugRenderer renderer;

    private Rectangle screenRightSide;
    private Rectangle screenLeftSide;

    private Vector3 touchPoint;

    private Panda panda;
    private BackgroundActor sideBounds;
    private BackgroundActor background;

    private Group obstacles;

    public GameStage(Viewport viewport, AssetManager assets){
        super(viewport);
        this.textureAtlas = assets.get(Constants.TEXTURE_ATLAS_FILENAME, TextureAtlas.class);
        float screenRatio = Gdx.graphics.getWidth() / (float) Constants.APP_WIDTH;

        setupCamera();
        setupWorld();
        setupTouchAreas();

        renderer = new Box2DDebugRenderer();
    }

    private void setupWorld(){
        world = WorldUtils.createWorld();
        world.setContactListener(this);

        setupBackground();
        obstacles = new Group();
        setupPanda();
        this.addActor(obstacles);
        setupBounds();
        createObstacle();
    }

    private void setupCamera(){
        camera = new OrthographicCamera(Constants.APP_WIDTH, Constants.APP_HEIGHT);
        camera.position.set(camera.viewportWidth / 2, camera.viewportHeight / 2, 0f);
        camera.update();
    }
     private void setupPanda(){
         panda = new Panda(WorldUtils.createPandaBody(world), textureAtlas.findRegion("panda_roll"));
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

     private void setupTouchAreas(){
        touchPoint = new Vector3();
        screenLeftSide = new Rectangle(0, 0,
                                getCamera().viewportWidth / 2, getCamera().viewportHeight);
        screenRightSide = new Rectangle(getCamera().viewportWidth / 2, 0,
                                    getCamera().viewportHeight / 2, getCamera().viewportHeight);
        Gdx.input.setInputProcessor(this);
     }

    @Override
    public void act(float delta){
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

        // Here interpolation would happen if we implemented one
    }

    private void update(Body body){
//        Gdx.app.log("DEBUG", "update body" + this.getActors().toString());
        if(!BodyUtils.bodyInBounds(body)){
            createObstacle();
            body.setUserData(null);
            world.destroyBody(body);
        }
    }

    private void createObstacle(){
        Body obstacleBody = WorldUtils.createObstacle(world);
        ObstacleUserData obstacleUserData = (ObstacleUserData) obstacleBody.getUserData();
        TextureRegion obstacleTextureRegion = textureAtlas.findRegion(obstacleUserData.getTextureName());
        obstacles.addActor(new Obstacle(obstacleBody, obstacleTextureRegion));
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
            panda.hit();
        }
    }

    @Override
    public void postSolve(Contact contact, ContactImpulse impulse) {
    }
}
