package com.mygdx.panda3.box2d;

import com.badlogic.gdx.math.Vector2;
import com.mygdx.panda3.enums.UserDataType;
import com.mygdx.panda3.utils.Constants;

public class RowUserData extends UserData {
    private Vector2 linearVelocity;
    private String textureName;

    public RowUserData(float width, float height, String textureName){
        super(width, height);
        userDataType = UserDataType.ROW;
        linearVelocity = Constants.ROW_LINEAR_VELOCITY;
        this.textureName = textureName;
    }

    public void setLinearVelocity(Vector2 linearVelocity){
        this.linearVelocity = linearVelocity;
    }

    public Vector2 getLinearVelocity(){
        return linearVelocity;
    }

    public String getTextureName(){
        return textureName;
    }
}
