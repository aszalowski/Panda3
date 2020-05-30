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



    public static final String OBSTACLE1_TEXTURE_NAME = "obstacle1";
    public static final float[][] OBSTACLE1_VERTICES = {{-152, -43, -152, 27, -80, 27, -80, -43}, {68, -44, 24, -15, 24, 43, 112, 43, 157, 12, 157, -43}};
    public static final String OBSTACLE2_TEXTURE_NAME = "obstacle2";
    public static final float[][] OBSTACLE2_VERTICES = {{-34, -43, -68, -14, -70, 15, -53, 43, 60, 43, 60, 4, 12, -43}};
    public static final String OBSTACLE3_TEXTURE_NAME = "obstacle3";
    public static final float[][] OBSTACLE3_VERTICES = {{-155, -41, -124, -41, -124, -7, -157, -7}, {154, -44, 127, -42, 127, -20, 140, -9, 156, -10}, {-22, 4, -34, 10, -32, 23, -20, 33, 14, 34, 28, 24, 29, 11, 18, 4}};
    public static final String OBSTACLE4_TEXTURE_NAME = "obstacle4";
    public static final float[][] OBSTACLE4_VERTICES = {{-157, -43, -86, -43, -157, -28, -157, 43}, {157, -42, 83, -41, 83, 43, 157, 43}};
    public static final String OBSTACLE5_TEXTURE_NAME = "obstacle5";
    public static final float[][] OBSTACLE5_VERTICES = {{-157, -43, -124, -41, -101, -26, -98, 5, -108, 15, -108, 23, -103, 28, -116, 43, -157, 43}, {2, -43, -14, -22, -6, -2, 15, -3, 20, 1, 31, 1, 41, -11, 40, -22, 30, -43}, {151, -43, 108, -16, 108, 5, 114, 40, 124, 40, 157, 13}};
    public static final String OBSTACLE6_TEXTURE_NAME = "obstacle6";
    public static final float[][] OBSTACLE6_VERTICES = {{-23, -42, -64, -15, -66, 8, -58, 43, 53, 43, 60, 33, 62, 7, 60, -14, 18, -42}};



    public static final float TIME_STEP = 1 / 300f;

}
