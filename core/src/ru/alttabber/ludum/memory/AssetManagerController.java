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
        assetManager.load(Assets.pressZ, Texture.class);
        assetManager.load(Assets.footStep, Sound.class);

        loadAnimationArray(Assets.frontTextureAnimation);
        loadAnimationArray(Assets.behindTextureAnimation);
        loadAnimationArray(Assets.rightTextureAnimation);
        loadAnimationArray(Assets.upRightTextureAnimation);
        loadAnimationArray(Assets.downRightTextureAnimation);
        loadAnimationArray(Assets.leftTextureAnimation);
        loadAnimationArray(Assets.upLeftTextureAnimation);
        loadAnimationArray(Assets.downLeftTextureAnimation);

    }

    public void loadItems(){
        assetManager.load(Assets.swordTexture, Texture.class);
        assetManager.load(Assets.oilTexture, Texture.class);
        assetManager.load(Assets.flareGunTexture, Texture.class);
        assetManager.load(Assets.compassTexture, Texture.class);
        assetManager.load(Assets.keyTexture, Texture.class);

        assetManager.load(Assets.floorExitOpen, Texture.class);
        assetManager.load(Assets.floorExitClosed, Texture.class);

        assetManager.load(Assets.wall, Texture.class);
        assetManager.load(Assets.floorTex, Texture.class);

        assetManager.load(Assets.arrowKey, Texture.class);
        assetManager.load(Assets.arrowExit, Texture.class);
    }

    public void loadGhost(){
        assetManager.load(Assets.ghostTexture, Texture.class);
        assetManager.load(Assets.ghostOverlayTexture, Texture.class);
    }

    public void loadSounds(){
        assetManager.load(Assets.ghostNoise1, Sound.class);
        assetManager.load(Assets.ghostNoise2, Sound.class);
        assetManager.load(Assets.ghostNoise3, Sound.class);

        assetManager.load(Assets.lampOilSound, Sound.class);
        assetManager.load(Assets.flareSound, Sound.class);
        assetManager.load(Assets.compassSound, Sound.class);
    }

    private void loadAnimationArray(String[] array){
        for(String path: array){
            assetManager.load(path, Texture.class);
        }
    }

}

