package ru.alttabber.ludum.units;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;

public abstract class Unit {

    protected float x;
    protected float y;
    protected int height;
    protected int width;
    protected Batch batch;

    public abstract void init(Batch batch);

    public abstract void draw();

    public Sprite createScaledSprite(Texture texture){
        return createScaledSprite(texture, this.x, this.y, this.width, this.height);
    }

    public Sprite createScaledSprite(Texture texture, float x, float y, int width, int height){
        Sprite sprite = new Sprite(texture, (int) x, (int) y, texture.getWidth(), texture.getHeight());
        sprite.setSize(width, height);

        return sprite;
    }
}
