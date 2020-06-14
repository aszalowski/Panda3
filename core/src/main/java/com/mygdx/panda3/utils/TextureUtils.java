package com.mygdx.panda3.utils;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

public class TextureUtils {
    public static Animation<TextureRegion> createFireAnimation(TextureAtlas textureAtlas){
        TextureRegion[] fireFrames = new TextureRegion[Constants.FIRE_FRAME_NUMBER];
        for(int i = 0; i < Constants.FIRE_FRAME_NUMBER; i++){
            fireFrames[i] = textureAtlas.findRegion(Constants.FIRE_BASE_TEXTURE_NAME + Integer.toString(i));
        }
        return new Animation<TextureRegion>(Constants.FIRE_FRAME_TIME, fireFrames);
    }

    public static Animation<TextureRegion> createRollingAnimation(TextureRegion pandaTexture){
        TextureRegion[] rollingFrames = new TextureRegion[Constants.PANDA_ROLL_FRAME_END - Constants.PANDA_ROLL_FRAME_START + 1];
        for(int i = 0; i < Constants.PANDA_ROLL_FRAME_END - Constants.PANDA_ROLL_FRAME_START + 1; i++){
            int frame = i + Constants.PANDA_ROLL_FRAME_START;
            int x = frame*Constants.PANDA_TEXTURE_WIDTH;
            rollingFrames[i] = new TextureRegion(pandaTexture, x, 0, Constants.PANDA_TEXTURE_WIDTH, Constants.PANDA_TEXTURE_HEIGHT);
        }

        return new Animation<TextureRegion>(Constants.PANDA_ROLL_FRAME_TIME, rollingFrames);
    }
}
