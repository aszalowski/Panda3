package com.mygdx.panda3.utils;

import com.mygdx.panda3.enums.ObstacleType;
import com.mygdx.panda3.enums.PowerUpType;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class RandomUtils {
    private static final Random RND = new Random();

    public static ObstacleType getRandomObstacleType(){
        RandomEnum<ObstacleType> randomEnum = new RandomEnum<ObstacleType>(ObstacleType.class);
        return randomEnum.random();
    }

    public static PowerUpType getRandomPowerUpType(){
        RandomEnum<PowerUpType> randomEnum = new RandomEnum<PowerUpType>(PowerUpType.class);
        return randomEnum.random();
    }

    public static float randomFloat(){
        return RND.nextFloat();
    }

    private static class RandomEnum<E extends Enum>{
        private final E[] values;

        RandomEnum(Class<E> token){
            values = token.getEnumConstants();
        }

        E random(){
            return values[RND.nextInt(values.length)];
        }
    }

}


