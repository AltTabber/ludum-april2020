package ru.alttabber.ludum.memory;

import com.badlogic.gdx.assets.AssetManager;

public class AssetManagerController {

    private AssetManager assetManager;

    public AssetManagerController() {
        this.assetManager = new AssetManager();
    }

    public AssetManager getAssetManager() {
        return assetManager;
    }
}

