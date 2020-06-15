package com.mygdx.panda3.actors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.mygdx.panda3.GdxTestRunner;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

@RunWith(GdxTestRunner.class)
public class HealthBarTest {
    @Test
    public void healthBarDecreasing(){
        Texture mockTexture = new Texture(Gdx.files.internal("src/test/mockTexture.png"));
        HealthBar healthBar = new HealthBar(new TextureRegion(mockTexture), 3);

        assertEquals(healthBar.getHealth(), 3);
        healthBar.decrease();
        assertEquals(healthBar.getHealth(), 2);
        healthBar.decrease();
        assertEquals(healthBar.getHealth(),1);
        healthBar.decrease();
        assertEquals(healthBar.getHealth(), 0);

        mockTexture.dispose();
    }

}