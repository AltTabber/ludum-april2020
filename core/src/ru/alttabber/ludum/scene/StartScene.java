package ru.alttabber.ludum.scene;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Vector2;
import ru.alttabber.ludum.gameobjects.AutomaticUsableObject;
import ru.alttabber.ludum.gameobjects.Teleport;
import ru.alttabber.ludum.gameobjects.Wall;
import ru.alttabber.ludum.gameobjects.items.FlareGunItem;
import ru.alttabber.ludum.gameobjects.items.OilLampItem;
import ru.alttabber.ludum.gameobjects.items.SwordItem;
import ru.alttabber.ludum.gameobjects.units.Ghost;
import ru.alttabber.ludum.gameobjects.items.Item;
import ru.alttabber.ludum.gameobjects.units.Player;
import ru.alttabber.ludum.memory.GameController;
import ru.alttabber.ludum.ui.MapController;
import ru.alttabber.ludum.utils.MaskedCircle;

import java.util.ArrayList;

public class StartScene extends Scene {


    Player player;
    Ghost ghost;

    MaskedCircle maskedCircle;
    MapController mapController;


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



        this.ghost = new Ghost();
        this.ghost.init(batch);

        this.walls = new ArrayList<>();
        this.walls.add(new Wall(new Vector2(800, 100), new Vector2(900, 500)));

        for (Wall wall : walls){
            wall.init(this.batch);
        }

//        GameController.getInstance().getCollisionController().addWalls(walls);


        OilLampItem oilLampItem = new OilLampItem();
        oilLampItem.init(batch);
        oilLampItem.setXY(200, 200);

        FlareGunItem flareGunItem = new FlareGunItem();
        flareGunItem.init(batch);
        flareGunItem.setXY(400, 200);

        GameController.getInstance().getCollisionController().addUsableObject(oilLampItem);
        GameController.getInstance().getCollisionController().addUsableObject(flareGunItem);

//        Teleport teleport = new Teleport();
//        teleport.init(batch);
//        GameController.getInstance().getCollisionController().addAutoUsableObject(teleport);

        maskedCircle = new MaskedCircle();
        maskedCircle.init(batch);

        mapController = new MapController();
        mapController.init(batch);

        GameController.getInstance().getCollisionController().addWalls(mapController.getWalls());


    }

    @Override
    public void draw() {

        GameController.getInstance().getCamera().update();
        batch.setProjectionMatrix(GameController.getInstance().getCamera().getCamera().combined);



        for(Wall wall: GameController.getInstance().getCollisionController().getWalls()){
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
