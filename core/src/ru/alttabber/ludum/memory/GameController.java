package ru.alttabber.ludum.memory;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import ru.alttabber.ludum.inputs.InputController;
import ru.alttabber.ludum.gameobjects.units.Player;
import ru.alttabber.ludum.utils.CollisionController;
import ru.alttabber.ludum.utils.LevelController;

public class GameController {

    private AssetManagerController assetController;
    private InputController inputController;
    private Player player;
    private CollisionController collisionController;
    private LevelController levelController;

    private static GameController instance;

    private GameController() {
        this.assetController = new AssetManagerController();
        this.inputController = new InputController();
        Gdx.input.setInputProcessor(inputController);
        collisionController = new CollisionController();
        this.levelController = new LevelController();
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

    public CollisionController getCollisionController() {
        return collisionController;
    }

    public LevelController getLevelController() {
        return levelController;
    }
}
