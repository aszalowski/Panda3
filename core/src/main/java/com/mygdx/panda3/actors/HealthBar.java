package com.mygdx.panda3.actors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Event;
import com.badlogic.gdx.scenes.scene2d.EventListener;
import com.mygdx.panda3.utils.Constants;

public class HealthBar extends Actor {
    private int health;
    private TextureRegion texture;
    private Vector2 texturePosition;

    public HealthBar(TextureRegion texture, int health){
        this.texture = texture;
        this.health = health;
        this.texturePosition = Constants.HEALTH_BAR_POSITION;
    }

    public int getHealth(){
        return health;
    }

    public void decrease(){
        health--;
    }

    @Override
    public void draw(Batch batch, float parentAlpha){
        super.draw(batch, parentAlpha);
        for(int i = 0; i < health; i++){
            float x = texturePosition.x + i*Constants.HEALTH_BAR_TEXTURE_WIDTH;
            batch.draw(texture, x, texturePosition.y);
        }
    }

}
