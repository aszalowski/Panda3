package com.mygdx.panda3.actors;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.physics.box2d.Body;
import com.mygdx.panda3.box2d.PandaUserData;
import com.mygdx.panda3.enums.MovingState;
import com.mygdx.panda3.utils.Constants;
import com.mygdx.panda3.utils.TextureUtils;



public class Panda extends GameActor {
    private int invTime;
    private boolean isInv;
    private boolean isOnFire;
    private float blinkingTimeCounter = 0;
    private boolean shouldBlink = false;
    private MovingState movingState;
    private Animation<TextureRegion> rollingAnimation;
    private Animation<TextureRegion> fireAnimation;
    private float stateTime;

    public Panda(Body body, TextureRegion pandaTexture, Animation<TextureRegion> fireAnimation){
        super(body, pandaTexture);
        rollingAnimation = TextureUtils.createRollingAnimation(pandaTexture);
        this.fireAnimation = fireAnimation;

        stateTime = 0;
        isOnFire = false;
        isInv = false;

    }

    @Override
    public PandaUserData getUserData(){
        return (PandaUserData) userData;
    }

    @Override
    public void draw(Batch batch, float parentAlpha){
        super.draw(batch, parentAlpha);
        updateTexturePosition();

        if(isOnFire){
            batch.draw(fireAnimation.getKeyFrame(stateTime, true), texturePosition.x + 3, texturePosition.y + 10);
        }

        batch.setColor(getColor());
        if(shouldBlink && invTime > 0){
            Color originalColor = batch.getColor();
            batch.setColor(originalColor.r, originalColor.g, originalColor.b, 0.2f);
            batch.draw(rollingAnimation.getKeyFrame(stateTime, true), texturePosition.x, texturePosition.y);
            handleBlinkReset();
        }
        else if(!shouldBlink && invTime > 0){
            batch.draw(rollingAnimation.getKeyFrame(stateTime, true), texturePosition.x, texturePosition.y);
            handleBlinkReset();
        }
        else{
            batch.draw(rollingAnimation.getKeyFrame(stateTime, true), texturePosition.x, texturePosition.y);
        }
        batch.setColor(Color.WHITE);

    }

    private void handleBlinkReset(){
        if(blinkingTimeCounter > Constants.PANDA_BLINK_TIME){
            blinkingTimeCounter = 0;
            shouldBlink = !shouldBlink;
        }
    }

    private void startBlinking(){
        shouldBlink = true;
        blinkingTimeCounter = 0;
    }

    @Override
    public void act(float delta){
        super.act(delta);

        stateTime += delta;

        if(invTime > 0){
            invTime -= delta;
            blinkingTimeCounter += delta;
        }
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
        if(invTime == 0){
            invTime = Constants.PANDA_INV_TIME;
            startBlinking();
        }
    }

    public boolean isInvulnerable(){
        return invTime > 0 || isInv;
    }

    public void setInv(boolean inv){
        this.isInv = inv;
    }

    public void setOnFire(boolean onFire){
        this.isOnFire = onFire;
    }

}
