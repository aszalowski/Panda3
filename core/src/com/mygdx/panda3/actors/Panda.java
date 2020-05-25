package com.mygdx.panda3.actors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.mygdx.panda3.box2d.PandaUserData;
import com.mygdx.panda3.enums.MovingState;

public class Panda extends GameActor {
    private boolean hit;
    private MovingState movingState;

    public Panda(Body body, TextureRegion texture){
        super(body, texture);
    }

    @Override
    public PandaUserData getUserData(){
        return (PandaUserData) userData;
    }

    @Override
    public void draw(Batch batch, float parentAlpha){
        super.draw(batch, parentAlpha);
        batch.draw(texture, texturePosition.x, texturePosition.y);
    }

    public void moveLeft(){
        if(movingState == MovingState.STOP) {
            body.setLinearVelocity(-getUserData().getVelocity(), 0f);
            movingState = MovingState.LEFT;
        }
    }

    public void moveRight(){
        if(movingState == MovingState.STOP) {
            body.setLinearVelocity(getUserData().getVelocity(), 0f);
            movingState = MovingState.RIGHT;
        }
    }

    public void stop(){
        body.setLinearVelocity(0f, 0f);
        movingState = MovingState.STOP;
    }

    public void hit(){
        Gdx.app.log("DEBUG", "Panda hit.");
        hit = true;
    }

    public boolean isHit(){
        return hit;
    }

}
