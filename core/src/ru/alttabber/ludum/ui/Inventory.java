package ru.alttabber.ludum.ui;

import com.badlogic.gdx.graphics.g2d.Batch;
import ru.alttabber.ludum.gameobjects.items.Item;

import java.util.ArrayList;
import java.util.List;

public class Inventory {

    List<Item> inventory;

    public Inventory() {
        this.inventory = new ArrayList<>();
    }

    public void addItem(Item item){
        this.inventory.add(item);
    }

    public boolean removeItem(Integer index){
        return inventory.remove(index);
    }

    public void draw(Batch batch){
        for(int i = 0; i<this.inventory.size(); i++){
            this.inventory.get(i).drawInventory(batch, 30 + 50*i, 50);
        }
    }

}
