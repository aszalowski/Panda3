package com.mygdx.panda3.utils;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Vector2;

public class Constants {
    public static final int APP_WIDTH = 378;
    public static final int APP_HEIGHT = 672;
    public static final int LEAVES_WIDTH = 12;

    public static final Vector2 WORLD_GRAVITY = new Vector2(0, 0);
    public static final float TIME_STEP = 1 / 300f;

    public static final String TEXTURE_ATLAS_FILENAME = "TextureAtlas.atlas";


    public static final String UI_SKIN_NAME = "skin.json";
    public static final String MEDIUM_FONT_NAME = "slkscr.ttf";
    public static final int MEDIUM_FONT_SIZE = 40;

    public static final int PAUSE_MENU_WIDTH = 216;
    public static final int PAUSE_MENU_HEIGHT = 384;



    public static final float BACKGROUND_LEAVES_SPEED = 100;
    public static final float BACKGROUND_SPEED = 200;

    public static final Vector2 PANDA_POSITION = new Vector2(APP_WIDTH / 2f, APP_HEIGHT - 100);
    public static final int PANDA_HEIGHT = 48;
    public static final int PANDA_WIDTH = 48;
    public static final float PANDA_DENSITY = 1f;
    public static final float PANDA_BASE_SPEED = 100;
    public static final int PANDA_INV_TIME = 100;
    public static final float PANDA_BLINK_TIME = 0.25f;

    public static final String PANDA_TEXTURE_NAME = "panda_roll";
    public static final int PANDA_TEXTURE_HEIGHT = 48;
    public static final int PANDA_TEXTURE_WIDTH = 56;
    public static final float[] PANDA_VERTICES = {-14, -21, -23, -9, -11, 16, 10, 16, 20, 4, 20, -12, 10, -2};
    public static final int PANDA_ROLL_FRAME_START = 3;
    public static final int PANDA_ROLL_FRAME_END = 7;
    public static final float PANDA_ROLL_FRAME_TIME = 0.12f;

    public static final int FIRE_FRAME_NUMBER = 6;
    public static final float FIRE_FRAME_TIME = 0.15f;
    public static final String FIRE_BASE_TEXTURE_NAME = "fire";

    public static final float ROW_DENSITY = 0f;
    public static final int ROW_HEIGHT = 86;
    public static final int ROW_WIDTH = APP_WIDTH - LEAVES_WIDTH*2;
    public static final Vector2 ROW_POSITION = new Vector2(APP_WIDTH / 2f, -ROW_HEIGHT);
    public static Vector2 ROW_LINEAR_VELOCITY = new Vector2(0, BACKGROUND_SPEED);

    public static final float OBSTACLE_SPAWN_DELAY = 1f;
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
    public static final float[][] OBSTACLE6_VERTICES = {{-24, -42, -63, -22, -61, 42, -3, 10, 53, 42, 63, 3, 57, -15, 19, -43}};

    public static final float GAME_STAGE_UI_HEIGHT = 48;

    public static final int STARTING_HEALTH = 3;
    public static final int HEALTH_BAR_TEXTURE_WIDTH = 32;
    public static final int HEALTH_BAR_TEXTURE_HEIGHT = 32;
    public static final String HEALTH_BAR_TEXTURE_NAME = "heart";
    public static final Vector2 HEALTH_BAR_POSITION =  new Vector2(25, Constants.APP_HEIGHT - HEALTH_BAR_TEXTURE_HEIGHT / 2f - 30);

    public static final Vector2 SCORE_BASE_POSITION =  new Vector2(Constants.APP_WIDTH - 60, Constants.APP_HEIGHT - 30);

    public static final String PAUSE_BUTTON_TEXTURE_NAME = "pause";
    public static final float PAUSE_BUTTON_WIDTH = 32;
    public static final float PAUSE_BUTTON_HEIGHT = 32;
    public static final Vector2 PAUSE_BUTTON_POSITION =  new Vector2(Constants.APP_WIDTH - 40,
            Constants.APP_HEIGHT - 30 - PAUSE_BUTTON_HEIGHT / 2f);

    public static final float SPEED_UP_DURATION = 8f;
    public static final float SPEED_UP_SPEED = 200;
    public static final String SPEED_UP_TEXTURE_NAME = "speed1";
    public static final float[][] SPEED_UP_VERTICES = { { 2, -15, 20, 10, 12, 16, -10, -5, -10, -14 } };

    public static final float INV_POWERUP_DURATION = 6f;
    public static final Color INV_POWERUP_COLOR = Color.GOLD;
    public static final String INV_TEXTURE_NAME = "inv1";
    public static final float[][] INV_VERTICES = { {10, -18, 7, 0, 17, 5, 10, 19, -14, 15, -19, 0, -8, 0, -9, -18} };


}
