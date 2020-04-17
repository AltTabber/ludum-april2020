package ru.alttabber.ludum.memory;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.audio.Sound;
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
        assetManager.load(Assets.pressZ, Texture.class);
        assetManager.load(Assets.footStep, Sound.class);

        loadAnimationArray(Assets.frontTextureAnimation);
        loadAnimationArray(Assets.behindTextureAnimation);
        loadAnimationArray(Assets.sideTextureAnimation);
        loadAnimationArray(Assets.frontSideTextureAnimation);
        loadAnimationArray(Assets.behindSideTextureAnimation);

    }

    public void loadItems(){
        assetManager.load(Assets.swordTexture, Texture.class);
    }

    private void loadAnimationArray(String[] array){
        for(String path: array){
            assetManager.load(path, Texture.class);
        }
    }
}

