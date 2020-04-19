package ru.alttabber.ludum.scene;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Vector2;
import ru.alttabber.ludum.gameobjects.AutomaticUsableObject;
import ru.alttabber.ludum.gameobjects.Teleport;
import ru.alttabber.ludum.gameobjects.Wall;
import ru.alttabber.ludum.gameobjects.items.SwordItem;
import ru.alttabber.ludum.gameobjects.units.Ghost;
import ru.alttabber.ludum.gameobjects.units.Item;
import ru.alttabber.ludum.gameobjects.units.Player;
import ru.alttabber.ludum.memory.Assets;
import ru.alttabber.ludum.memory.GameController;
import ru.alttabber.ludum.ui.Camera;
import ru.alttabber.ludum.utils.MaskedCircle;
import ru.alttabber.ludum.utils.SpriteAnimation;

import java.util.ArrayList;

public class StartScene extends Scene {


    Player player;
    SwordItem sword;
    Ghost ghost;

    MaskedCircle maskedCircle;


    public StartScene() {
    }

    @Override
    public void init(Batch batch) {
        GameController.getInstance().getCamera().init();

        super.init(batch);

        GameController.getInstance().getAssetController().loadPlayerAssets();
        GameController.getInstance().getAssetController().loadItems();
        GameController.getInstance().getAssetController().loadGhost();
        GameController.getInstance().getAssetManager().finishLoading();

        player = new Player();
        player.init(batch);

        GameController.getInstance().setPlayer(player);

        sword = new SwordItem();
        sword.init(batch);

        this.ghost = new Ghost();
        this.ghost.init(batch);

        this.walls = new ArrayList<>();
        this.walls.add(new Wall(new Vector2(800, 100), new Vector2(900, 500)));

        for (Wall wall : walls){
            wall.init(this.batch);
        }

        GameController.getInstance().getCollisionController().addWalls(walls);

        GameController.getInstance().getCollisionController().addUsableObject(sword);

        Teleport teleport = new Teleport();
        teleport.init(batch);
        GameController.getInstance().getCollisionController().addAutoUsableObject(teleport);

        maskedCircle = new MaskedCircle();
        maskedCircle.init(batch);

    }

    @Override
    public void draw() {

        GameController.getInstance().getCamera().update();
        batch.setProjectionMatrix(GameController.getInstance().getCamera().getCamera().combined);



        for(Wall wall: this.walls){
            wall.draw();
        }

        for(Item obj: GameController.getInstance().getCollisionController().getUsableObjects()){
            obj.draw();
        }

        for(AutomaticUsableObject obj: GameController.getInstance().getCollisionController().getAutoUseObjects()){
            obj.draw();
        }

        player.draw();

        this.ghost.draw();

        maskedCircle.draw();

        this.ghost.drawOnOverlay();

    }
}
