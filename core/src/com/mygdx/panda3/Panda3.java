package com.mygdx.panda3;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Version;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.assets.loaders.FileHandleResolver;
import com.badlogic.gdx.assets.loaders.SkinLoader;
import com.badlogic.gdx.assets.loaders.resolvers.InternalFileHandleResolver;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.CpuSpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGeneratorLoader;
import com.badlogic.gdx.graphics.g2d.freetype.FreetypeFontLoader;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.utils.ObjectMap;
import com.mygdx.panda3.screens.GameScreen;
import com.mygdx.panda3.screens.MainMenuScreen;
import com.mygdx.panda3.utils.Constants;

import org.omg.CORBA.CODESET_INCOMPATIBLE;


public class Panda3 extends Game {

	private AssetManager manager;

	@Override
	public void create () {
		manager = new AssetManager();
		FileHandleResolver resolver = new InternalFileHandleResolver();
		manager.setLoader(FreeTypeFontGenerator.class, new FreeTypeFontGeneratorLoader(resolver));
		manager.setLoader(BitmapFont.class, ".ttf", new FreetypeFontLoader(resolver));

		manager.load(Constants.TEXTURE_ATLAS_FILENAME, TextureAtlas.class);

		FreetypeFontLoader.FreeTypeFontLoaderParameter mediumFontLoader = new FreetypeFontLoader.FreeTypeFontLoaderParameter();
		mediumFontLoader.fontFileName = Constants.MEDIUM_FONT_NAME;
		mediumFontLoader.fontParameters.size = Constants.MEDIUM_FONT_SIZE;
		manager.load(Constants.MEDIUM_FONT_NAME, BitmapFont.class, mediumFontLoader);
		manager.finishLoadingAsset(Constants.MEDIUM_FONT_NAME);

		ObjectMap<String, Object> fontMap = new ObjectMap<String, Object>();
		fontMap.put(Constants.MEDIUM_FONT_NAME, manager.get(Constants.MEDIUM_FONT_NAME));

		SkinLoader.SkinParameter skinParameter = new SkinLoader.SkinParameter(fontMap);
		manager.load(Constants.UI_SKIN_NAME, Skin.class, skinParameter);


		manager.finishLoading();
		setScreen(new MainMenuScreen(this, manager));
	}

}
