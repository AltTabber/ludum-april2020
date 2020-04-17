package ru.alttabber.ludum.ui;

import ru.alttabber.ludum.gameobjects.units.Item;

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

}
