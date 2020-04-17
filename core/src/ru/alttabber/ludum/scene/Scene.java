package ru.alttabber.ludum.scene;

import com.badlogic.gdx.graphics.g2d.Batch;
import ru.alttabber.ludum.gameobjects.Wall;
import ru.alttabber.ludum.utils.CollisionController;

import java.util.List;

public abstract class Scene {

    protected List<Wall> walls;

    public abstract void draw();

    public abstract void init(Batch batch);


}
