package com.mygdx.panda3.actors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.mygdx.panda3.box2d.PandaUserData;
import com.mygdx.panda3.enums.MovingState;
import com.mygdx.panda3.utils.Constants;

import javax.xml.soap.Text;

public class Panda extends GameActor {
    private boolean hit;
    private MovingState movingState;
    private Animation<TextureRegion> rollingAnimation;
    private float stateTime;

    public Panda(Body body, TextureRegion texture){
        super(body, texture);
        TextureRegion[] rollingFrames = new TextureRegion[Constants.PANDA_ROLL_FRAME_END - Constants.PANDA_ROLL_FRAME_START + 1];
        for(int i = 0; i < Constants.PANDA_ROLL_FRAME_END - Constants.PANDA_ROLL_FRAME_START + 1; i++){
            int frame = i + Constants.PANDA_ROLL_FRAME_START;
            int x = frame*Constants.PANDA_TEXTURE_WIDTH;
            rollingFrames[i] = new TextureRegion(texture, x, 0, Constants.PANDA_TEXTURE_WIDTH, Constants.PANDA_TEXTURE_HEIGHT);
        }
        rollingAnimation = new Animation<TextureRegion>(Constants.PANDA_ROLL_FRAME_TIME, rollingFrames);
        stateTime = 0;


    }

    @Override
    public PandaUserData getUserData(){
        return (PandaUserData) userData;
    }

    @Override
    public void draw(Batch batch, float parentAlpha){
        super.draw(batch, parentAlpha);
        stateTime += Gdx.graphics.getDeltaTime();
        updateTexturePosition();
        batch.draw(rollingAnimation.getKeyFrame(stateTime, true), texturePosition.x, texturePosition.y);
    }

    private void updateTexturePosition(){
        texturePosition.set(body.getPosition().x - Constants.PANDA_TEXTURE_WIDTH / 2f,
                body.getPosition().y - Constants.PANDA_TEXTURE_HEIGHT / 2f);
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
