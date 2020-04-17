package ru.alttabber.ludum.scene;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Vector2;
import ru.alttabber.ludum.gameobjects.Wall;
import ru.alttabber.ludum.gameobjects.items.SwordItem;
import ru.alttabber.ludum.gameobjects.units.Player;
import ru.alttabber.ludum.memory.Assets;
import ru.alttabber.ludum.memory.GameController;
import ru.alttabber.ludum.utils.CollisionController;
import ru.alttabber.ludum.utils.SpriteAnimation;

import java.util.ArrayList;

public class StartScene extends Scene {


    Player player;
    SwordItem item;
    SpriteAnimation animation;

    Batch batch;

    public StartScene() {
    }

    @Override
    public void init(Batch batch) {
        this.batch = batch;

        GameController.getInstance().getAssetController().loadPlayerAssets();
        GameController.getInstance().getAssetController().loadItems();
        GameController.getInstance().getAssetManager().finishLoading();

        animation = new SpriteAnimation(Assets.frontTextureAnimation, 200,200);
        animation.init(batch);

        player = new Player();
        player.init(batch);

        GameController.getInstance().setPlayer(player);

        item = new SwordItem();
        item.init(batch);

        this.walls = new ArrayList<>();
        this.walls.add(new Wall(new Vector2(800, 100), new Vector2(900, 500)));

        for (Wall wall : walls){
            wall.init(this.batch);
        }

        GameController.getInstance().getCollisionController().addWalls(walls);
    }

    @Override
    public void draw() {
        for(Wall wall: this.walls){
            wall.draw();
        }
        item.draw();
        player.draw();
        animation.draw();
    }
}
