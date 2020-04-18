package ru.alttabber.ludum.gameobjects;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;

public abstract class GameObject extends Actor {

    protected Vector2 XY = new Vector2();
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

        return sprite;
    }

    public Vector2 getXY() {
        return XY;
    }

    public float getX(){
        return XY.x;
    }

    public float getY(){
        return XY.y;
    }

}
