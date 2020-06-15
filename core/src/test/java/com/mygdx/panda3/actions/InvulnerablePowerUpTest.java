package com.mygdx.panda3.actions;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Colors;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;
import com.mygdx.panda3.GdxTestRunner;
import com.mygdx.panda3.actors.Panda;
import com.mygdx.panda3.utils.Constants;
import com.mygdx.panda3.utils.WorldUtils;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

@RunWith(GdxTestRunner.class)
public class InvulnerablePowerUpTest {

    @Test
    public void powerUpTiming(){
        World world = WorldUtils.createWorld();
        Texture mockTexture = new Texture(Gdx.files.internal("src/test/mockTexture.png"));
        Panda panda = new Panda(WorldUtils.createPandaBody(world), new TextureRegion(mockTexture), null);

        // Check initial state of panda
        assertFalse(panda.isInvulnerable());
        assertEquals(panda.getColor(), Color.WHITE);

        // Create and attach powerup
        InvulnerablePowerUp powerUp = new InvulnerablePowerUp();
        panda.addAction(powerUp);

        // Half of powerup duration
        powerUp.act(Constants.INV_POWERUP_DURATION / 2f);
        assertTrue(panda.isInvulnerable());
        assertEquals(panda.getColor(), Constants.INV_POWERUP_COLOR);

        // Powerup expires
        powerUp.act(Constants.INV_POWERUP_DURATION / 2f);

        assertFalse(panda.isInvulnerable());
        assertEquals(panda.getColor(), Color.WHITE);

        mockTexture.dispose();
    }

}