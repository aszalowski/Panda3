package com.mygdx.panda3.box2d;

import com.badlogic.gdx.scenes.scene2d.Action;
import com.mygdx.panda3.enums.UserDataType;


public class PowerUpUserData extends RowUserData {
    private Class<? extends Action> powerUpClass;

    public PowerUpUserData(float width, float height, String textureName, Class<? extends Action> powerUpClass){
        super(width, height, textureName);
        userDataType = UserDataType.POWERUP;
        this.powerUpClass = powerUpClass;
    }

    public Class<? extends Action> getPowerUpClass(){
        return powerUpClass;
    }
}
