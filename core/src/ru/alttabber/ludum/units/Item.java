package ru.alttabber.ludum.units;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import ru.alttabber.ludum.memory.Assets;
import ru.alttabber.ludum.memory.GameController;

public class Item implements MapUsableObject {

    protected String name;
    protected Texture texture;
    protected Sprite sprite;

    protected Batch batch;

    protected float x;
    protected float y;

    protected float width;
    protected float height;

    @Override
    public void doMapAction() {
        addToInventory();
        destroyItem();
    }

    @Override
    public void destroyItem() {
        //TODO
    }

    @Override
    public void draw() {
        sprite.setPosition(this.x, this.y);
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



}
