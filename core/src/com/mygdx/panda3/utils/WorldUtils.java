package com.mygdx.panda3.utils;

import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.math.Vector2;


public class WorldUtils {

    public static World createWorld(){
        return new World(Constants.WORLD_GRAVITY, true);
    }

}
