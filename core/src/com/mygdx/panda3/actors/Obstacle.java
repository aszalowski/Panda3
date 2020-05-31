package com.mygdx.panda3.actors;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.physics.box2d.Body;
import com.mygdx.panda3.box2d.ObstacleUserData;
import com.mygdx.panda3.utils.Constants;

public class Obstacle extends Row {
    public Obstacle(Body body, TextureRegion texture){
        super(body, texture);
    }

    @Override
    public ObstacleUserData getUserData() {
        return (ObstacleUserData) userData;
    }

    @Override
    public void draw(Batch batch, float parentAlpha){
        super.draw(batch, parentAlpha);
        batch.draw(texture, texturePosition.x, texturePosition.y);
    }
}
