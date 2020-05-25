package com.mygdx.panda3.box2d;

import com.badlogic.gdx.math.Vector2;
import com.mygdx.panda3.enums.UserDataType;
import com.mygdx.panda3.utils.Constants;

import sun.awt.geom.AreaOp;

public class PandaUserData extends UserData {

    private float velocity;

    public PandaUserData(float width, float height){
        super(width, height);
        velocity = Constants.PANDA_BASE_SPEED;
        userDataType = UserDataType.PANDA;
    }

    public float getVelocity(){
        return velocity;
    }

    public void setVelocity(float aVelocity){
        velocity = aVelocity;
    }


}
