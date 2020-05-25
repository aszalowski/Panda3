package com.mygdx.panda3.screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.mygdx.panda3.stages.GameStage;
import com.mygdx.panda3.utils.Constants;

public class GameScreen implements Screen {

    private GameStage stage;
    private Game game;
    private StretchViewport viewport;

    public GameScreen(Game aGame, AssetManager assets){
        viewport = new StretchViewport(Constants.APP_WIDTH, Constants.APP_HEIGHT);
        stage = new GameStage(viewport, assets);
        game = aGame;
    }

    @Override
    public void render(float delta) {
        // Clear the screen
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        stage.draw();
        stage.act(delta);

    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void show() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void dispose() {

    }

}
