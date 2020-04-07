package ru.alttabber.ludum.units;

import com.badlogic.gdx.graphics.g2d.Batch;

public abstract class Unit {

    protected int X;
    protected int Y;
    protected int height;
    protected int width;

    public abstract void init(Batch batch);

}
