package ru.alttabber.ludum.memory;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import ru.alttabber.ludum.inputs.InputController;
import ru.alttabber.ludum.units.Player;

public class GameController {

    private AssetManagerController assetController;
    private InputController inputController;
    private Player player;

    private static GameController instance;

    private GameController() {
        this.assetController = new AssetManagerController();
        this.inputController = new InputController();
        Gdx.input.setInputProcessor(inputController);
    }

    public static GameController getInstance(){
        if( instance == null){
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

    public InputController getInputController() {
        return inputController;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }
}
