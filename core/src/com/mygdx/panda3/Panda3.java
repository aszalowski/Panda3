package com.mygdx.panda3;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.mygdx.panda3.screens.GameScreen;
import com.mygdx.panda3.screens.MainMenuScreen;
import com.mygdx.panda3.utils.Constants;


public class Panda3 extends Game {

	private AssetManager textureManager;

	@Override
	public void create () {
		textureManager = new AssetManager();
		textureManager.load(Constants.TEXTURE_ATLAS_FILENAME, TextureAtlas.class);
		textureManager.finishLoading();
		setScreen(new GameScreen(this, textureManager));
	}

}
