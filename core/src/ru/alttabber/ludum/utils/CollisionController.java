package ru.alttabber.ludum.utils;

import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Intersector;
import ru.alttabber.ludum.gameobjects.Wall;
import ru.alttabber.ludum.gameobjects.units.Item;
import ru.alttabber.ludum.gameobjects.units.MapUsableObject;

import java.util.ArrayList;
import java.util.List;

public class CollisionController {

    private List<Wall> impassableObjects;
    private List<Item> usableObjects;

    public CollisionController() {
        impassableObjects = new ArrayList<>();
        usableObjects = new ArrayList<>();
    }

    public void addWalls(List<Wall> walls){
        impassableObjects.addAll(walls);
    }

    public boolean isMovementPossible(Circle playerCircle){
        for(Wall wall: impassableObjects){
            if(Intersector.overlaps(playerCircle, wall.getRectangle())){
                return false;
            }
        }
        return true;
    }

    public Item getUsableObject(Circle playerCircle){
        Item returnedObject = null;
        for(Item usableObject: usableObjects){
            if(Intersector.overlaps(playerCircle, usableObject.getRectangle())){
                returnedObject = usableObject;
            }
        }
        return returnedObject;
    }

    public void addUsableObject(Item obj){
        usableObjects.add(obj);
    }

    public List<Item> getUsableObjects() {
        return usableObjects;
    }

    public void clear(){
        this.impassableObjects.clear();
    }

    public void removeItem(Item item) {
        usableObjects.remove(item);
    }
}
