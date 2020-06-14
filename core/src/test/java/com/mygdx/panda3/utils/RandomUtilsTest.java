package com.mygdx.panda3.utils;

import com.mygdx.panda3.GdxTestRunner;
import com.mygdx.panda3.actors.Obstacle;
import com.mygdx.panda3.enums.ObstacleType;
import com.mygdx.panda3.enums.PowerUpType;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

@RunWith(GdxTestRunner.class)
public class RandomUtilsTest {
    @Test
    public void obstaclesEqualDistribution(){
        int[] numberOfOccurrences = new int [ObstacleType.values().length];

        // Generate population
        int TEST_SIZE = 1000000;
        for(int i = 0; i < TEST_SIZE; i++)
            numberOfOccurrences[RandomUtils.getRandomObstacleType().ordinal()]++;

        float expectedPercent = 100f / ObstacleType.values().length;
        for(int i = 0; i < ObstacleType.values().length; i++){
            float percent = numberOfOccurrences[i] * 100 / (float) TEST_SIZE;
            assertEquals(percent, expectedPercent, 0.5f);
        }
    }

    @Test
    public void powerUpsEqualDistribution(){
        int[] numberOfOccurrences = new int [PowerUpType.values().length];

        // Generate population
        int TEST_SIZE = 1000000;
        for(int i = 0; i < TEST_SIZE; i++)
            numberOfOccurrences[RandomUtils.getRandomPowerUpType().ordinal()]++;

        float expectedPercent = 100f / PowerUpType.values().length;
        for(int i = 0; i < PowerUpType.values().length; i++){
            float percent = numberOfOccurrences[i] * 100 / (float) TEST_SIZE;
            assertEquals(percent, expectedPercent, 0.5f);
        }
    }

}