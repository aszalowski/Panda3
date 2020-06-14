package com.mygdx.panda3.stages;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.Window;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.mygdx.panda3.screens.GameScreen;
import com.mygdx.panda3.utils.Constants;

public class GameOverUIStage extends Stage {
    private GameScreen parent;
    private Table table;
    private AssetManager assets;
    private Label scoreLabel;

    public GameOverUIStage(GameScreen parent, Viewport viewport, AssetManager assets){
        super(viewport);
        this.parent = parent;
        this.assets = assets;


        setupUI();
    }

    public void setScore(int score){
        scoreLabel.setText("Score: " + Integer.toString(score));
    }

    private void setupUI(){
        Skin skin = assets.get(Constants.UI_SKIN_NAME);
        table = new Table(skin);
        this.addActor(table);
        float fontScale = 0.65f;

        table.setFillParent(true);

        Window window = new Window("Game Over", skin);
        window.getTitleLabel().setFontScale(fontScale);
        window.getTitleLabel().setAlignment(Align.center);
        window.align(Align.center);

        scoreLabel = new Label("Score", skin);
        scoreLabel.setFontScale(fontScale);
        window.add(scoreLabel).padBottom(20f).row();

        TextButton playAgainButton = new TextButton("Play again", skin);
        playAgainButton.getLabel().setFontScale(fontScale);
        playAgainButton.addListener(new ChangeListener() { @Override public void changed(ChangeEvent event, Actor actor) {
            parent.restart();
        }
        });
        TextButton exitButton = new TextButton("Exit", skin);
        exitButton.getLabel().setFontScale(fontScale);
        exitButton.addListener(new ChangeListener() { @Override public void changed(ChangeEvent event, Actor actor) {
            parent.exitToMenu();
        }
        });
        window.add(playAgainButton).align(Align.center).fillX().row();
        window.add(exitButton).align(Align.center).fillX().padTop(10f).row();
        window.add("").row();
        window.pack();

        table.add(window).width(Constants.PAUSE_MENU_WIDTH).height(Constants.PAUSE_MENU_HEIGHT);
    }
}
