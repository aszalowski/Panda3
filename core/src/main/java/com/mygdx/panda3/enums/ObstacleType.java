package com.mygdx.panda3.enums;

import com.mygdx.panda3.utils.Constants;

public enum ObstacleType {

    OBSTACLE1(Constants.OBSTACLE1_TEXTURE_NAME, Constants.OBSTACLE1_VERTICES),
    OBSTACLE2(Constants.OBSTACLE2_TEXTURE_NAME, Constants.OBSTACLE2_VERTICES),
    OBSTACLE3(Constants.OBSTACLE3_TEXTURE_NAME, Constants.OBSTACLE3_VERTICES),
    OBSTACLE4(Constants.OBSTACLE4_TEXTURE_NAME, Constants.OBSTACLE4_VERTICES),
    OBSTACLE5(Constants.OBSTACLE5_TEXTURE_NAME, Constants.OBSTACLE5_VERTICES),
    OBSTACLE6(Constants.OBSTACLE6_TEXTURE_NAME, Constants.OBSTACLE6_VERTICES);

    private String textureName;
    private float[][] shapeDefinition;

    ObstacleType(String textureName, float[][] shapeDefinition){
        this.textureName = textureName;
        this.shapeDefinition = shapeDefinition;
    }

    public String getTextureName(){
        return textureName;
    }

    public float[][] getShapeDefinition(){
        return shapeDefinition;
    }
}
