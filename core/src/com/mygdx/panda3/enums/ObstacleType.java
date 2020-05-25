package com.mygdx.panda3.enums;

import com.mygdx.panda3.utils.Constants;

public enum ObstacleType {

    SMALL_WINES(Constants.WIDE_WINES_TEXTURE_NAME, Constants.WIDE_WINES_SHAPES);

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
