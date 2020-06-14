package com.mygdx.panda3.actions;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.physics.box2d.World;
import com.mygdx.panda3.GdxTestRunner;
import com.mygdx.panda3.actors.Panda;
import com.mygdx.panda3.utils.Constants;
import com.mygdx.panda3.utils.WorldUtils;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

@RunWith(GdxTestRunner.class)
public class SpeedUpPowerUpTest {
    @Test
    public void powerUpTiming(){
        World world = WorldUtils.createWorld();
        Texture mockTexture = new Texture(Gdx.files.internal("src/test/mockTexture.png"));
        Panda panda = new Panda(WorldUtils.createPandaBody(world), new TextureRegion(mockTexture), null);

        // Check initial state of panda
        assertEquals(panda.getUserData().getVelocity(), Constants.PANDA_BASE_SPEED, 0.000001f);

        // Create and attach powerup
        SpeedUpPowerUp powerUp = new SpeedUpPowerUp();
        panda.addAction(powerUp);

        // Half of powerup duration
        powerUp.act(Constants.SPEED_UP_DURATION / 2f);
        assertEquals(panda.getUserData().getVelocity(), Constants.SPEED_UP_SPEED, 0.000001f);

        // Powerup expires
        powerUp.act(Constants.SPEED_UP_DURATION / 2f);
        assertEquals(panda.getUserData().getVelocity(), Constants.PANDA_BASE_SPEED, 0.000001f);

        mockTexture.dispose();
    }

}