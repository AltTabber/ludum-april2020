package ru.alttabber.ludum.scene;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import ru.alttabber.ludum.gameobjects.AutomaticUsableObject;
import ru.alttabber.ludum.gameobjects.Wall;
import ru.alttabber.ludum.gameobjects.items.FlareGunItem;
import ru.alttabber.ludum.gameobjects.items.OilLampItem;
import ru.alttabber.ludum.gameobjects.units.Ghost;
import ru.alttabber.ludum.gameobjects.items.Item;
import ru.alttabber.ludum.gameobjects.units.Player;
import ru.alttabber.ludum.memory.Assets;
import ru.alttabber.ludum.memory.Game;
import ru.alttabber.ludum.ui.CompassUI;
import ru.alttabber.ludum.ui.MapController;
import ru.alttabber.ludum.utils.MaskedCircle;
import ru.alttabber.ludum.utils.SoundManager;

import java.util.ArrayList;

public class StartScene extends Scene {


    Player player;
    Ghost ghost;
    Texture floor;
    CompassUI compassUI;

    MaskedCircle maskedCircle;
    MapController mapController;
    SoundManager soundManager;


    public StartScene() {
    }

    @Override
    public void init(Batch batch) {
        Game.getInstance().getCamera().init();

        super.init(new SpriteBatch());

        Game.getInstance().getAssetController().loadPlayerAssets();
        Game.getInstance().getAssetController().loadItems();
        Game.getInstance().getAssetController().loadGhost();
        Game.getInstance().getAssetController().loadSounds();
        Game.getInstance().getAssetManager().finishLoading();

        player = new Player();
        player.init(this.batch);

        Game.getInstance().setPlayer(player);



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

        Game.getInstance().getCollisionController().addUsableObject(oilLampItem);
        Game.getInstance().getCollisionController().addUsableObject(flareGunItem);

        maskedCircle = new MaskedCircle();
        maskedCircle.init(this.batch);

        mapController = new MapController();
        mapController.init(this.batch);

        Game.getInstance().getCollisionController().addWalls(mapController.getWalls());

        floor = Game.getInstance().getAssetManager().get(Assets.floorTex, Texture.class);

        compassUI = new CompassUI();
        compassUI.init(this.batch);

        Game.getInstance().setCompass(compassUI);

        soundManager = new SoundManager();
        soundManager.init();
        soundManager.playWhiteNoise();
        soundManager.setNoiseLevel(0);

        Game.getInstance().setSoundManager(soundManager);
        Game.getInstance().setMaskedCircle(maskedCircle);

    }

    @Override
    public void draw() {
        batch.begin();

        Game.getInstance().getCamera().update();
        batch.setProjectionMatrix(Game.getInstance().getCamera().getCamera().combined);

        for(int i = 0; i < 100; i++){
            for(int j = 0; j < 100; j++){
                batch.draw(floor, i * floor.getWidth(), j * floor.getHeight());
            }
        }

        for(Wall wall: Game.getInstance().getCollisionController().getWalls()){
            wall.draw();
        }

        for(Item obj: Game.getInstance().getCollisionController().getUsableObjects()){
            obj.draw();
        }

        for(AutomaticUsableObject obj: Game.getInstance().getCollisionController().getAutoUseObjects()){
            obj.draw();
        }

        player.draw();

        for(Ghost ghost : Game.getInstance().getCollisionController().getEnemies()){
            ghost.draw();
        }

        maskedCircle.draw();

        for(Ghost ghost : Game.getInstance().getCollisionController().getEnemies()){
            ghost.drawOnOverlay();
        }

        compassUI.draw();

        soundManager.updateSounds();

        if(Game.getInstance().getPlayer().isDead()){
            Game.getInstance().getLevelController().chooseLevel(GameOverScene.class).init(batch);
        }

        batch.end();

    }
}
