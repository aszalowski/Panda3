package com.mygdx.panda3.utils;

import com.badlogic.gdx.math.Vector2;

public class Constants {
    public static final int APP_WIDTH = 378;
    public static final int APP_HEIGHT = 672;
    public static final int LEAVES_WIDTH = 12;

    public static final Vector2 WORLD_GRAVITY = new Vector2(0, 0);
    public static final float TIME_STEP = 1 / 300f;

    public static final String TEXTURE_ATLAS_FILENAME = "TextureAtlas.atlas";


    public static final float BACKGROUND_LEAVES_SPEED = 100;
    public static final float BACKGROUND_SPEED = 200;

    public static final Vector2 PANDA_POSITION = new Vector2(APP_WIDTH / 2f, APP_HEIGHT - 100);
    public static final int PANDA_HEIGHT = 48;
    public static final int PANDA_WIDTH = 48;
    public static final float PANDA_DENSITY = 1f;
    public static final float PANDA_BASE_SPEED = 100;

    public static final int PANDA_TEXTURE_HEIGHT = 48;
    public static final int PANDA_TEXTURE_WIDTH = 56;
    public static final int PANDA_ROLL_FRAME_START = 3;
    public static final int PANDA_ROLL_FRAME_END = 7;
    public static final float PANDA_ROLL_FRAME_TIME = 0.12f;

    public static final float ROW_DENSITY = 0f;//PANDA_DENSITY;
    public static final int ROW_HEIGHT = 86;
    public static final int ROW_WIDTH = APP_WIDTH - LEAVES_WIDTH*2;
    public static final Vector2 ROW_POSITION = new Vector2(APP_WIDTH / 2f, -ROW_HEIGHT);
    public static Vector2 ROW_LINEAR_VELOCITY = new Vector2(0, BACKGROUND_SPEED);



    public static final String OBSTACLE1_TEXTURE_NAME = "obstacle1";
    public static final float[][] OBSTACLE1_VERTICES = {{-170, -34, -173, 35, -110, 36, -96, 23, -102, -34}, {85, -41, 44, -15, 43, 42, 128, 42, 171, 10, 170, -42}};
    public static final String OBSTACLE2_TEXTURE_NAME = "obstacle2";
    public static final float[][] OBSTACLE2_VERTICES = {{-32, -43, -35, -19, -49, -15, -64, -16, -65, 4, -69, 9, -48, 43, 47, 43, 59, 32, 59, 28, 53, 3, 43, 3, 41, -11, 27, -12, 10, -43}};
    public static final String OBSTACLE3_TEXTURE_NAME = "obstacle3";
    public static final float[][] OBSTACLE3_VERTICES = {{-177, -10, -137, -10, -126, -20, -126, -32, -136, -40, -177, -38}, {-21, 3, -31, 12, -31, 21, -20, 33, 10, 34, 28, 24, 30, 12, 18, 2}, {177, -42, 138, -42, 126, -33, 127, -22, 141, -12, 177, -11}};
    public static final String OBSTACLE4_TEXTURE_NAME = "obstacle4";
    public static final float[][] OBSTACLE4_VERTICES = {{-175, -42, -106, -42, -96, 26, -111, 42, -171, 41}, {176, -42, 110, -42, 101, 1, 107, 39, 167, 41}};
    public static final String OBSTACLE5_TEXTURE_NAME = "obstacle5";
    public static final float[][] OBSTACLE5_VERTICES = {{-177, -43, -133, -42, -122, -26, -120, 6, -133, 41, -177, 40}, {-18, -42, -34, -14, -25, -3, 15, -1, 18, -20, 9, -42}, {157, -42, 117, -16, 120, 42, 127, 42, 175, 8}};
    public static final String OBSTACLE6_TEXTURE_NAME = "obstacle6";
    public static final float[][] OBSTACLE6_VERTICES = {{-24, -42, -63, -42, -61, 42, -3, 10, 53, 42, 63, 3, 57, -15, 19, -43}};
}
