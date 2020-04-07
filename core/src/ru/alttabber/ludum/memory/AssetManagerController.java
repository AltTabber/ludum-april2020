package ru.alttabber.ludum.memory;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;

public class AssetManagerController {

    private AssetManager assetManager;

    public AssetManagerController() {
        this.assetManager = new AssetManager();
    }

    public AssetManager getAssetManager() {
        return assetManager;
    }

    public void loadPlayerAsset(){
        assetManager.load("front.png", Texture.class);
        assetManager.load("12.png", Texture.class);
        assetManager.load("34behind.png", Texture.class);
        assetManager.load("34front.png", Texture.class);
        assetManager.load("behind.png", Texture.class);
    }
}

