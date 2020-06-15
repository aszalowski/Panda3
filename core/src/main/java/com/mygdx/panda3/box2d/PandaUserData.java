package com.mygdx.panda3.box2d;

import com.mygdx.panda3.enums.UserDataType;
import com.mygdx.panda3.utils.Constants;


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
