package com.mygdx.panda3.box2d;

import com.mygdx.panda3.enums.UserDataType;

public class ObstacleUserData extends RowUserData {
    public ObstacleUserData(float width, float height, String textureName){
        super(width, height, textureName);
        userDataType = UserDataType.OBSTACLE;
    }

}
