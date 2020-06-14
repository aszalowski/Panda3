package com.mygdx.panda3.actions;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.actions.ColorAction;
import com.badlogic.gdx.scenes.scene2d.actions.TemporalAction;
import com.mygdx.panda3.actors.Panda;
import com.mygdx.panda3.utils.Constants;

public class InvulnerablePowerUp extends TemporalAction {
    public InvulnerablePowerUp(){
        super(Constants.INV_POWERUP_DURATION);
    }

    @Override
    public void update(float percent){
    }

    @Override
    public void begin(){
        super.begin();
        ((Panda) target).setInv(true);
        target.setColor(Constants.INV_POWERUP_COLOR);
    }

    @Override
    public void end(){
        super.end();
        ((Panda) target).setInv(false);
        target.setColor(Color.WHITE);
    }
}
