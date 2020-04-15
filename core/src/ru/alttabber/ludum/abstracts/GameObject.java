package ru.alttabber.ludum.abstracts;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;

public abstract class GameObject {

    protected float x;
    protected float y;
    protected int height;
    protected int width;
    protected Batch batch;

    public abstract void draw();

    public abstract void init(Batch batch);

    public Sprite createScaledSprite(Texture texture){
        return createScaledSprite(texture, this.width, this.height);
    }

    public Sprite createScaledSprite(Texture texture, int width, int height){
        Sprite sprite = new Sprite(texture, 0, 0, texture.getWidth(), texture.getHeight());
        sprite.setSize(width, height);

        return sprite;//sdfsdfsdf
    }


}
