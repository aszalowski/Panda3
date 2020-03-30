package com.mygdx.panda3.stages;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;

import com.mygdx.panda3.utils.WorldUtils;
import com.mygdx.panda3.utils.Constants;

import javax.swing.Spring;

public class GameStage extends Stage {
    private World world;
    private SpriteBatch batch;
    private Texture img;

    private final float TIME_STEP = 1 / 300f;
    private float accumulator = 0f;

    private OrthographicCamera camera;
    private Box2DDebugRenderer renderer;

    public GameStage(){
        world = WorldUtils.createWorld();
        renderer = new Box2DDebugRenderer();

        batch = new SpriteBatch();
        img = new Texture("background_leaves.png");
        setupCamera();
    }

    private void setupCamera(){
        camera = new OrthographicCamera(Constants.APP_WIDTH, Constants.APP_HEIGHT);
        camera.position.set(camera.viewportWidth / 2, camera.viewportHeight / 2, 0f);
        camera.update();
    }

    @Override
    public void act(float delta){
        super.act(delta);

        // Fixed interval
        accumulator += delta;

        while(accumulator >= delta){
            world.step(TIME_STEP, 6, 2);
            accumulator -= TIME_STEP;
        }

        // Here interpolation would happen if we implemented one
    }

    @Override
    public void draw(){
        super.draw();
        batch.setProjectionMatrix(camera.combined);
        batch.begin();
        batch.draw(img, 0, 0, Constants.APP_WIDTH, Constants.APP_HEIGHT);
        batch.end();
        renderer.render(world, camera.combined);
    }

}
