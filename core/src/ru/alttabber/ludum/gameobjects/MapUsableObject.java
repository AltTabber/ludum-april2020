package ru.alttabber.ludum.gameobjects;

import com.badlogic.gdx.math.Rectangle;

public interface MapUsableObject {

    void doMapAction();

    void destroyItem();

    Rectangle getRectangle();
}
