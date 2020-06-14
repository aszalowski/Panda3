package com.mygdx.panda3.utils;

import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.EdgeShape;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;
import com.mygdx.panda3.box2d.ObstacleUserData;
import com.mygdx.panda3.box2d.PandaUserData;
import com.mygdx.panda3.box2d.PowerUpUserData;
import com.mygdx.panda3.box2d.SideBoundsUserData;
import com.mygdx.panda3.enums.ObstacleType;
import com.mygdx.panda3.enums.PowerUpType;


public class WorldUtils {

    public static World createWorld(){
        return new World(Constants.WORLD_GRAVITY, true);
    }

    public static Body createPandaBody(World world){
        BodyDef bodyDef = new BodyDef();
        bodyDef.type = BodyDef.BodyType.DynamicBody;
        bodyDef.position.set(Constants.PANDA_POSITION);
        PolygonShape shape = new PolygonShape();
        shape.set(Constants.PANDA_VERTICES);
        Body body = world.createBody(bodyDef);
        body.createFixture(shape, Constants.PANDA_DENSITY);
        body.resetMassData();
        body.setUserData(new PandaUserData(Constants.PANDA_WIDTH, Constants.PANDA_HEIGHT));
        shape.dispose();
        return body;
    }

    public static Body createObstacle(World world){
        ObstacleType obstacleType = RandomUtils.getRandomObstacleType();
        BodyDef bodyDef = new BodyDef();
        bodyDef.type = BodyDef.BodyType.KinematicBody;
        bodyDef.position.set(Constants.ROW_POSITION);
        Body body = world.createBody(bodyDef);
        for(float[] vertices : obstacleType.getShapeDefinition()){
            PolygonShape shape = new PolygonShape();
            shape.set(vertices);
            body.createFixture(shape, Constants.ROW_DENSITY);
            shape.dispose();
        }
        ObstacleUserData userData = new ObstacleUserData(Constants.ROW_WIDTH, Constants.ROW_HEIGHT, obstacleType.getTextureName());
        body.setUserData(userData);
        return body;
    }

    public static Body createPowerUp(World world){
        PowerUpType powerUpType = RandomUtils.getRandomPowerUpType();
        BodyDef bodyDef = new BodyDef();
        bodyDef.type = BodyDef.BodyType.KinematicBody;
        bodyDef.position.set(Constants.ROW_POSITION);
        Body body = world.createBody(bodyDef);
        for(float[] vertices : powerUpType.getShapeDefinition()){
            PolygonShape shape = new PolygonShape();
            shape.set(vertices);
            body.createFixture(shape, Constants.ROW_DENSITY);
            shape.dispose();
        }
        PowerUpUserData userData = new PowerUpUserData(Constants.ROW_WIDTH, Constants.ROW_HEIGHT, powerUpType.getTextureName(), powerUpType.getPowerUpClass());
        body.setUserData(userData);
        return body;

    }

    public static Body createSideBoundsBody(World world){
        BodyDef bodyDef = new BodyDef();
        bodyDef.type = BodyDef.BodyType.StaticBody;
        bodyDef.position.set(Constants.APP_WIDTH / 2f, Constants.APP_HEIGHT / 2f);

        EdgeShape leftBoundShape = new EdgeShape();
        EdgeShape rightBoundShape = new EdgeShape();
        leftBoundShape.set( -Constants.APP_WIDTH / 2f + Constants.LEAVES_WIDTH, -Constants.APP_HEIGHT / 2f,
                            -Constants.APP_WIDTH / 2f + Constants.LEAVES_WIDTH, Constants.APP_HEIGHT / 2f);
        rightBoundShape.set(Constants.APP_WIDTH / 2f - Constants.LEAVES_WIDTH, -Constants.APP_HEIGHT / 2f,
                            Constants.APP_WIDTH / 2f - Constants.LEAVES_WIDTH, Constants.APP_HEIGHT / 2f);

        Body body = world.createBody(bodyDef);
        body.createFixture(leftBoundShape, 1f);
        body.createFixture(rightBoundShape, 1f);
        body.setUserData(new SideBoundsUserData(Constants.APP_WIDTH, Constants.APP_HEIGHT));

        leftBoundShape.dispose();
        rightBoundShape.dispose();
        return body;
    }

}
