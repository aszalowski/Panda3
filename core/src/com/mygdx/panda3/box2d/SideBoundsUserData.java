package com.mygdx.panda3.box2d;

import com.mygdx.panda3.enums.UserDataType;

public class SideBoundsUserData extends UserData {

    public SideBoundsUserData(float width, float height){
        super(width, height);
        userDataType = UserDataType.SIDE_BOUNDS;
    }
}
