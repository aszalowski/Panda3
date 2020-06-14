package com.mygdx.panda3.utils;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.physics.box2d.Body;
import com.mygdx.panda3.box2d.UserData;
import com.mygdx.panda3.enums.UserDataType;

public class BodyUtils{
    public static boolean bodyInBounds(Body body) {
        UserData userData = (UserData) body.getUserData();

        switch (userData.getUserDataType()) {
            case PANDA:
                return true;
            case POWERUP:
            case OBSTACLE:
                return body.getPosition().y - userData.getHeight() / 2 < Constants.APP_HEIGHT;
        }

        return true;
    }

    public static boolean bodyIsPowerUp(Body body){
        UserData userData = (UserData) body.getUserData();
        return userData != null && userData.getUserDataType() == UserDataType.POWERUP;
    }

    public static boolean bodyIsObstacle(Body body){
        UserData userData = (UserData) body.getUserData();
        return userData != null && userData.getUserDataType() == UserDataType.OBSTACLE;
    }

    public static boolean bodyIsPanda(Body body){
        UserData userData = (UserData) body.getUserData();
        return userData != null && userData.getUserDataType() == UserDataType.PANDA;
    }

}
