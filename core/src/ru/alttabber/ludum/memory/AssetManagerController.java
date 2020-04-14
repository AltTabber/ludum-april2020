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

    public void loadPlayerAssets(){
        assetManager.load(Assets.frontTexture, Texture.class);
        assetManager.load(Assets.sideTexture, Texture.class);
        assetManager.load(Assets.sideBehindTexture, Texture.class);
        assetManager.load(Assets.sideFrontTexture, Texture.class);
        assetManager.load(Assets.behindTexture, Texture.class);
    }

    public void loadItems(){
        assetManager.load(Assets.swordTexture, Texture.class);
    }
}

