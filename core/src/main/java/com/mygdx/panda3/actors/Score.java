package com.mygdx.panda3.actors;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.mygdx.panda3.utils.Constants;


public class Score extends Actor {
    private int score;
    private float remainder;
    private BitmapFont font;
    private GlyphLayout layout;
    private Vector2 position;
    private boolean isPaused;

    public Score(BitmapFont font){
        this.font = font;
        score = 0;
        remainder = 0;
        isPaused = true;
        position = new Vector2();
        updateLayout();
        updatePosition();
    }

    @Override
    public void draw(Batch batch, float parentAlpha){
        super.draw(batch, parentAlpha);
        updateLayout();
        updatePosition();
        font.draw(batch, layout, position.x, position.y);
    }

    @Override
    public void act(float delta){
        super.act(delta);
        if(!isPaused){
            remainder += delta * 10;
            if(remainder > 1){
                score += 1;
                remainder -= 1;
            }
        }
    }

    private void updateLayout(){
        layout = new GlyphLayout(font, Integer.toString(score));
    }

    private void updatePosition(){
        position.x = Constants.SCORE_BASE_POSITION.x - layout.width;
        position.y = Constants.SCORE_BASE_POSITION.y + layout.height / 2f;
    }

    public int getScore(){
        return score;
    }

    public void pause(){
        isPaused = true;
    }

    public void start(){
        isPaused = false;
    }
}
