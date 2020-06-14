package com.mygdx.panda3.enums;

import com.badlogic.gdx.scenes.scene2d.Action;
import com.mygdx.panda3.actions.InvulnerablePowerUp;
import com.mygdx.panda3.actions.SpeedUpPowerUp;
import com.mygdx.panda3.utils.Constants;

public enum PowerUpType {
    SPEED_UP(Constants.SPEED_UP_TEXTURE_NAME, Constants.SPEED_UP_VERTICES, SpeedUpPowerUp.class),
    INVULNERABLE(Constants.INV_TEXTURE_NAME, Constants.INV_VERTICES, InvulnerablePowerUp.class);

    private String textureName;
    private float[][] shapeDefinition;
    private Class<? extends Action> powerUpClass;

    PowerUpType(String textureName, float[][] shapeDefinition, Class<? extends Action> powerUpClass){
        this.textureName = textureName;
        this.shapeDefinition = shapeDefinition;
        this.powerUpClass = powerUpClass;
    }

    public String getTextureName(){
        return textureName;
    }

    public float[][] getShapeDefinition(){
        return shapeDefinition;
    }

    public Class<? extends Action> getPowerUpClass(){
        return powerUpClass;
    }
}
