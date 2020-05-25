package com.mygdx.panda3.actors;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.mygdx.panda3.box2d.SideBoundsUserData;
import com.mygdx.panda3.utils.Constants;

public class SideBounds extends GameActor {
    private Vector2 texturePositionBottom;
    private float speed = Constants.BACKGROUND_LEAVES_SPEED;

    public SideBounds(Body body, TextureRegion texture){
        super(body, texture);
        texturePosition = new Vector2(0 , 0);
        texturePositionBottom = new Vector2(0,  - Constants.APP_HEIGHT);
    }

    @Override
    public SideBoundsUserData getUserData(){
        return (SideBoundsUserData) userData;
    }

    @Override
    public void act(float delta) {
        if (topBoundsReached(delta)) {
            resetBounds();
        } else {
            updateTexturePosition(delta);
        }
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);
        batch.draw(texture, texturePosition.x, texturePosition.y);
        batch.draw(texture, texturePositionBottom.x, texturePositionBottom.y);
    }

    private boolean topBoundsReached(float delta) {
        return (texturePosition.y + (delta * speed)) >= Constants.APP_HEIGHT ;
    }

    private void updateTexturePosition(float delta) {
        texturePosition.y += delta * speed;
        texturePositionBottom.y += delta * speed;
    }

    private void resetBounds() {
        texturePosition = texturePositionBottom;
        texturePositionBottom = new Vector2(0,  - Constants.APP_HEIGHT);
    }

}
