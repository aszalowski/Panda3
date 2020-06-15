package com.mygdx.panda3.actors;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.physics.box2d.Body;
import com.mygdx.panda3.box2d.ObstacleUserData;

public class Obstacle extends Row {
    public Obstacle(Body body, TextureRegion texture){
        super(body, texture);
//        setColor(Color.BLUE.cpy().lerp(Color.WHITE, 0.5f));
    }

    @Override
    public ObstacleUserData getUserData() {
        return (ObstacleUserData) userData;
    }

    @Override
    public void draw(Batch batch, float parentAlpha){
        super.draw(batch, parentAlpha);
        batch.setColor(getColor());
        batch.draw(texture, texturePosition.x, texturePosition.y);
        batch.setColor(Color.WHITE);
    }
}
