package ru.alttabber.ludum.units;

import com.badlogic.gdx.graphics.g2d.Batch;

public interface MapUsableObject {

    void doMapAction();

    void destroyItem();

    void draw();

    void init(Batch batch);

}
