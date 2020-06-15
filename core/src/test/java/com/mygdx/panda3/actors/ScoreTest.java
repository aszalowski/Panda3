package com.mygdx.panda3.actors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.mygdx.panda3.GdxTestRunner;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

@RunWith(GdxTestRunner.class)
public class ScoreTest {
    @Test
    public void scoreCounting(){
        BitmapFont font = new BitmapFont(Gdx.files.internal("src/test/mockFont.fnt"));
        Score score = new Score(font);

        // Initial state
        assertEquals(score.getScore(), 0);
        assertTrue(score.isPaused());

        // Score is paused so it doesn't grow
        score.act(0.2f);
        assertEquals(score.getScore(), 0);

        score.act(0.2f);
        assertEquals(score.getScore(), 0);

        // Start counting
        score.start();
        assertFalse(score.isPaused());

        score.act(0.05f);
        assertEquals(score.getScore(), 0);

        score.act(0.1f);
        assertEquals(score.getScore(), 1);

        score.act(0.05f);
        assertEquals(score.getScore(), 1);

        score.act(0.001f);
        assertEquals(score.getScore(), 2);

        font.dispose();
    }

}