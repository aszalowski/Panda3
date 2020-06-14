package com.mygdx.panda3.actions;

import com.badlogic.gdx.scenes.scene2d.actions.TemporalAction;
import com.mygdx.panda3.actors.Panda;
import com.mygdx.panda3.utils.Constants;

public class SpeedUpPowerUp extends TemporalAction {
    public SpeedUpPowerUp(){
        super(Constants.SPEED_UP_DURATION);
    }

    @Override
    public void update(float percent){
    }

    @Override
    public void begin(){
        ((Panda) target).setOnFire(true);
        ((Panda) target).getUserData().setVelocity(Constants.SPEED_UP_SPEED);
    }

    @Override
    public void end(){
        ((Panda) target).setOnFire(false);
        ((Panda) target).getUserData().setVelocity(Constants.PANDA_BASE_SPEED);
    }
}
