package com.mygdx.panda3.actors;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.mygdx.panda3.stages.GameStage;
import com.mygdx.panda3.utils.Constants;

public class PauseButton{
    private ImageButton button;
    public PauseButton(TextureRegion texture){
        TextureRegionDrawable image = new TextureRegionDrawable(texture);
        button = new ImageButton(image);
        button.setPosition(Constants.PAUSE_BUTTON_POSITION.x, Constants.PAUSE_BUTTON_POSITION.y);
        button.addListener(new ChangeListener() { @Override public void changed(ChangeEvent event, Actor actor) {
            GameStage gameStage = (GameStage) button.getStage();
            gameStage.getParentScreen().pause();
        }
        });
    }

    public ImageButton getButton(){
        return button;
    }
}
