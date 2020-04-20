package ru.alttabber.ludum.scene;

import com.badlogic.gdx.graphics.g2d.Batch;
import ru.alttabber.ludum.gameobjects.Wall;
import ru.alttabber.ludum.memory.Game;

import java.util.List;

public abstract class Scene {

    protected String sceneName;

    protected List<Wall> walls;
    Batch batch;

    public abstract void draw();

    public void init(Batch batch){
        Game.getInstance().getCollisionController().clear();
        this.batch = batch;
    }


}
