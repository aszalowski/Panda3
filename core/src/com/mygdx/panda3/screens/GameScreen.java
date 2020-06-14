package com.mygdx.panda3.screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.mygdx.panda3.enums.GameStageState;
import com.mygdx.panda3.stages.GameOverUIStage;
import com.mygdx.panda3.stages.GameStage;
import com.mygdx.panda3.stages.PauseUIStage;
import com.mygdx.panda3.utils.Constants;

public class GameScreen implements Screen {

    private GameStage gameStage;
    private PauseUIStage pauseUIStage;
    private GameOverUIStage gameOverUIStage;
    private Game game;
    private StretchViewport viewport;
    private AssetManager assets;

    public GameScreen(Game aGame, AssetManager assets){
        viewport = new StretchViewport(Constants.APP_WIDTH, Constants.APP_HEIGHT);
        gameStage = new GameStage(this, viewport, assets);
        pauseUIStage = new PauseUIStage(this, viewport, assets);
        gameOverUIStage = new GameOverUIStage(this, viewport, assets);
        game = aGame;
        this.assets = assets;

        Gdx.input.setInputProcessor(gameStage);
    }

    public void gameover(int score){
        gameOverUIStage.setScore(score);
        Gdx.input.setInputProcessor(gameOverUIStage);
    }

    public void restart(){
        gameStage.restart();
        Gdx.input.setInputProcessor(gameStage);
    }

    @Override
    public void render(float delta) {
        // Clear the screen
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        gameStage.draw();
        gameStage.act(delta);

        if(gameStage.getGameState() == GameStageState.PAUSED){
            pauseUIStage.draw();
            pauseUIStage.act(delta);
        }

        if(gameStage.getGameState() == GameStageState.ENDED){
            gameOverUIStage.draw();
            gameOverUIStage.act(delta);
        }
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
        gameStage.setGameState(GameStageState.PAUSED);
        Gdx.input.setInputProcessor(pauseUIStage);
    }

    public void unpause(){
        gameStage.setGameState(GameStageState.RUNNING);
        Gdx.input.setInputProcessor(gameStage);
    }

    @Override
    public void resume() {

    }

    @Override
    public void dispose() {

    }

    public void exitToMenu(){
        game.setScreen(new MainMenuScreen(game, assets));
    }

}
