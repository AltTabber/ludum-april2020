package ru.alttabber.ludum.gameobjects.items;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Rectangle;
import ru.alttabber.ludum.gameobjects.GameObject;
import ru.alttabber.ludum.gameobjects.MapUsableObject;
import ru.alttabber.ludum.memory.GameController;

public class Item extends GameObject implements MapUsableObject {

    protected String name;
    protected Texture texture;
    protected Sprite spriteInventory;
    protected Sprite sprite;
    protected Rectangle rectangle;

    @Override
    public void doMapAction() {
        addToInventory();
        destroyItem();
    }

    @Override
    public void destroyItem() {
        GameController.getInstance().getCollisionController().removeItem(this);
    }

    @Override
    public Rectangle getRectangle() {
        return rectangle;
    }

    @Override
    public void draw() {
        sprite.setPosition(this.XY.x, this.XY.y);
        this.sprite.draw(batch);
    }

    @Override
    public void init(Batch batch) {
        this.batch = batch;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addToInventory(){
        GameController.getInstance().getPlayer().getInventory().addItem(this);
        destroyItem();
    }

    public void setXY(float x, float y){
        this.XY.x = x;
        this.XY.y = y;

        this.rectangle.x = x;
        this.rectangle.y = y;
    }

    public void drawInventory(Batch batch, float x, float y) {
        if(this.spriteInventory != null ){
            this.spriteInventory.setX(x);
            this.spriteInventory.setY(y);
            this.spriteInventory.draw(batch);
        }
    }
}
