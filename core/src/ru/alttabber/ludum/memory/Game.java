package ru.alttabber.ludum.memory;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import ru.alttabber.ludum.inputs.InputController;
import ru.alttabber.ludum.gameobjects.units.Player;
import ru.alttabber.ludum.ui.Camera;
import ru.alttabber.ludum.ui.CompassUI;
import ru.alttabber.ludum.utils.CollisionController;
import ru.alttabber.ludum.utils.LevelController;

public class Game {

    private AssetManagerController assetController;
    private InputController inputController;
    private Player player;
    private CollisionController collisionController;
    private LevelController levelController;
    private Camera camera;
    private ExitState exitState;
    private CompassUI compassUI;

    private static Game instance;

    private Game() {
        this.assetController = new AssetManagerController();
        this.inputController = new InputController();
        Gdx.input.setInputProcessor(inputController);
        collisionController = new CollisionController();
        this.levelController = new LevelController();
        this.camera = new Camera();
        this.exitState = ExitState.EXIT_CLOSED;
    }

    public static Game getInstance(){
        if( instance == null){
            instance = new Game();
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

    public Camera getCamera() {
        return camera;
    }

    public ExitState getExitState() {
        return exitState;
    }

    public void setExitState(ExitState exitState) {
        this.exitState = exitState;
    }

    public void setCompass(CompassUI compassUI) {
        this.compassUI = compassUI;
    }

    public CompassUI getCompassUI() {
        return compassUI;
    }
}
