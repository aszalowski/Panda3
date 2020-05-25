package com.mygdx.panda3.actors;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.physics.box2d.Body;
import com.mygdx.panda3.box2d.RowUserData;

public abstract class Row extends GameActor {
    public Row(Body body, TextureRegion texture){
        super(body, texture);
    }

    @Override
    public RowUserData getUserData() {
        return (RowUserData) userData;
    }

    @Override
    public void act(float delta) {
        super.act(delta);
        body.setLinearVelocity(getUserData().getLinearVelocity());
    }

}
