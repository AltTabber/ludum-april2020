package ru.alttabber.ludum.gameobjects;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Rectangle;
import ru.alttabber.ludum.window.Window;

public class AutomaticUsableObject extends GameObject implements MapUsableObject {

    Rectangle rect;

    @Override
    public void draw() {

    }

    @Override
    public void init(Batch batch) {
        this.batch = batch;
        this.rect = new Rectangle();
    }

    @Override
    public void doMapAction() {

    }

    @Override
    public void destroyItem() {

    }

    @Override
    public Rectangle getRectangle() {
        return this.rect;
    }

}
