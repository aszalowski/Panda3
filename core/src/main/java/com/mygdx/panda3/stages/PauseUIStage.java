package com.mygdx.panda3.stages;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.Window;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.mygdx.panda3.screens.GameScreen;
import com.mygdx.panda3.utils.Constants;

public class PauseUIStage extends Stage {

    private GameScreen parent;
    private Table table;
    private AssetManager assets;

    public PauseUIStage(GameScreen parent, Viewport viewport, AssetManager assets){
        super(viewport);
        this.parent = parent;
        this.assets = assets;


        setupUI();
    }

    private void setupUI(){
        Skin skin = assets.get(Constants.UI_SKIN_NAME);
        table = new Table(skin);
        this.addActor(table);

        table.setFillParent(true);

        Window window = new Window("Pause Menu", skin);
        window.getTitleLabel().setFontScale(0.7f);
        window.getTitleLabel().setAlignment(Align.center);
        window.align(Align.top);
        table.add(window).width(Constants.PAUSE_MENU_WIDTH).height(Constants.PAUSE_MENU_HEIGHT);

        TextButton resumeButton = new TextButton("Resume", skin);
        resumeButton.getLabel().setFontScale(0.7f);
        resumeButton.addListener(new ChangeListener() { @Override public void changed(ChangeEvent event, Actor actor) {
                parent.unpause();
            }
        });
        window.add(resumeButton).padTop(50f).fillX().row();



    }

}
