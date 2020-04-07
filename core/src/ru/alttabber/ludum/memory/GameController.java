package ru.alttabber.ludum.memory;

import com.badlogic.gdx.assets.AssetManager;

public class GameController {

    private AssetManagerController assetController;
    private static GameController instance = new GameController();

    private GameController() {
        assetController = new AssetManagerController();
    }

    public static GameController getInstance(){
        if( instance != null){
            instance = new GameController();
        }
        return instance;
    }

    public AssetManagerController getAssetController(){
        return assetController;
    }

    public AssetManager getAssetManager(){
        return assetController.getAssetManager();
    }

}
