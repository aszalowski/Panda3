package com.mygdx.panda3.utils;

import com.badlogic.gdx.math.Vector2;

public class Constants {
    public static final int APP_WIDTH = 378;
    public static final int APP_HEIGHT = 672;
    public static final int LEAVES_WIDTH = 28;

    public static final Vector2 WORLD_GRAVITY = new Vector2(0, 0);

    public static final String TEXTURE_ATLAS_FILENAME = "TextureAtlas.atlas";


    public static final float BACKGROUND_LEAVES_SPEED = 100;

    public static final Vector2 PANDA_POSITION = new Vector2(APP_WIDTH / 2f, APP_HEIGHT - 100);
    public static final int PANDA_HEIGHT = 47;
    public static final int PANDA_WIDTH = 47;
    public static final float PANDA_DENSITY = 1f;
    public static final float PANDA_BASE_SPEED = 100;

    public static final float ROW_DENSITY = 0f;//PANDA_DENSITY;
    public static final int ROW_HEIGHT = 86;
    public static final int ROW_WIDTH = APP_WIDTH - LEAVES_WIDTH*2;
    public static final Vector2 ROW_POSITION = new Vector2(APP_WIDTH / 2f, -ROW_HEIGHT);
    public static Vector2 ROW_LINEAR_VELOCITY = new Vector2(0, 200);



    public static final String WIDE_WINES_TEXTURE_NAME = "bamboo";
    public static final float[][] WIDE_WINES_SHAPES = {{0, 0, 0, 10, 10, 10, 0, 10}, {20, 20, 20, 30, 30, 30, 20, 30}};


    public static final float TIME_STEP = 1 / 300f;

}
