package ru.alttabber.ludum.scene;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import ru.alttabber.ludum.gameobjects.AutomaticUsableObject;
import ru.alttabber.ludum.gameobjects.Teleport;
import ru.alttabber.ludum.gameobjects.Wall;
import ru.alttabber.ludum.gameobjects.items.FlareGunItem;
import ru.alttabber.ludum.gameobjects.items.OilLampItem;
import ru.alttabber.ludum.gameobjects.units.Ghost;
import ru.alttabber.ludum.gameobjects.items.Item;
import ru.alttabber.ludum.gameobjects.units.Player;
import ru.alttabber.ludum.memory.Assets;
import ru.alttabber.ludum.memory.GameController;
import ru.alttabber.ludum.ui.CompassUI;
import ru.alttabber.ludum.ui.MapController;
import ru.alttabber.ludum.utils.MaskedCircle;

import java.util.ArrayList;

public class StartScene extends Scene {


    Player player;
    Ghost ghost;
    Texture floor;
    CompassUI compassUI;

    MaskedCircle maskedCircle;
    MapController mapController;


    public StartScene() {
    }

    @Override
    public void init(Batch batch) {
        GameController.getInstance().getCamera().init();

        super.init(new SpriteBatch());

        GameController.getInstance().getAssetController().loadPlayerAssets();
        GameController.getInstance().getAssetController().loadItems();
        GameController.getInstance().getAssetController().loadGhost();
        GameController.getInstance().getAssetManager().finishLoading();

        player = new Player();
        player.init(this.batch);

        GameController.getInstance().setPlayer(player);



//        this.ghost = new Ghost();
//        this.ghost.init(this.batch);

        this.walls = new ArrayList<>();
        this.walls.add(new Wall(new Vector2(800, 100), new Vector2(900, 500)));

        for (Wall wall : walls){
            wall.init(this.batch);
        }

//        GameController.getInstance().getCollisionController().addWalls(walls);


        OilLampItem oilLampItem = new OilLampItem();
        oilLampItem.init(this.batch);
        oilLampItem.setXY(200, 200);

        FlareGunItem flareGunItem = new FlareGunItem();
        flareGunItem.init(this.batch);
        flareGunItem.setXY(400, 200);

        GameController.getInstance().getCollisionController().addUsableObject(oilLampItem);
        GameController.getInstance().getCollisionController().addUsableObject(flareGunItem);

        maskedCircle = new MaskedCircle();
        maskedCircle.init(this.batch);

        mapController = new MapController();
        mapController.init(this.batch);

        GameController.getInstance().getCollisionController().addWalls(mapController.getWalls());

        floor = GameController.getInstance().getAssetManager().get(Assets.floorTex, Texture.class);

        compassUI = new CompassUI();
        compassUI.init(this.batch);

        GameController.getInstance().setCompass(compassUI);
    }

    @Override
    public void draw() {
        batch.begin();

        GameController.getInstance().getCamera().update();
        batch.setProjectionMatrix(GameController.getInstance().getCamera().getCamera().combined);

        for(int i = 0; i < 100; i++){
            for(int j = 0; j < 100; j++){
                batch.draw(floor, i * floor.getWidth(), j * floor.getHeight());
            }
        }

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

        for(Ghost ghost : GameController.getInstance().getCollisionController().getEnemies()){
            ghost.draw();
        }

        maskedCircle.draw();

        for(Ghost ghost : GameController.getInstance().getCollisionController().getEnemies()){
            ghost.drawOnOverlay();
        }

        compassUI.draw();


        batch.end();

    }
}
