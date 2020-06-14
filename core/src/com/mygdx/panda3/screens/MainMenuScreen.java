package com.mygdx.panda3.screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.mygdx.panda3.utils.Constants;

public class MainMenuScreen implements Screen {
    private Game parent;
    private Stage stage;
    private ExtendViewport viewport;
    private AssetManager assets;
    public MainMenuScreen(Game aParent, AssetManager assets){
        parent = aParent;
        this.assets = assets;
        viewport = new ExtendViewport(Constants.APP_WIDTH, Constants.APP_HEIGHT);
        stage = new Stage(viewport);

        Gdx.input.setInputProcessor(stage);
    }

    @Override
    public void show(){
        Skin skin = assets.get(Constants.UI_SKIN_NAME);
        Table table = new Table(skin);

        table.setFillParent(true);
        table.setDebug(true);
        table.setBackground("list");

        stage.addActor(table);

        TextButton playButton = new TextButton("PLAY", skin);


        table.add(playButton).fillX().uniformX().height(100).width(200);

        // TODO Implement changing screens in Game class
        playButton.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                parent.setScreen(new GameScreen(parent, assets));
            }
        });
    }

    @Override
    public void render(float delta){
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        stage.draw();
        stage.act(delta);
    }

    @Override
    public void resize(int width, int height) {

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
