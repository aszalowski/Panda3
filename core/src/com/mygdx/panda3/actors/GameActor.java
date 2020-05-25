package com.mygdx.panda3.actors;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.mygdx.panda3.box2d.UserData;
import com.mygdx.panda3.utils.Constants;

public abstract class GameActor extends Actor {
    protected Body body;
    protected UserData userData;
    protected TextureRegion texture;
    protected Vector2 texturePosition;

    public GameActor(Body body, TextureRegion texture){
        this.body = body;
        this.texture = texture;
        this.userData = (UserData) body.getUserData();
        texturePosition = new Vector2();
    }

    public abstract UserData getUserData();

    @Override
    public void act(float delta) {
        super.act(delta);
        if (body.getUserData() == null) {
            remove();
        }
        else{
            updateTexturePosition();
        }
    }

   private void updateTexturePosition(){
        texturePosition.set(body.getPosition().x - texture.getRegionWidth() / 2f,
                body.getPosition().y - texture.getRegionHeight() / 2f);
   }


}
