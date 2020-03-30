package com.mygdx.panda3;

import com.badlogic.gdx.Game;
import com.mygdx.panda3.screens.GameScreen;


public class Panda3 extends Game {

	@Override
	public void create () {
		setScreen(new GameScreen());
	}

}
