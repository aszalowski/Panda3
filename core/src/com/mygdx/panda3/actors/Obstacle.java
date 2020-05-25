package com.mygdx.panda3.actors;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.physics.box2d.Body;
import com.mygdx.panda3.box2d.ObstacleUserData;

public class Obstacle extends Row {
    public Obstacle(Body body, TextureRegion texture){
        super(body, texture);
    }

    @Override
    public ObstacleUserData getUserData() {
        return (ObstacleUserData) userData;
    }
}
