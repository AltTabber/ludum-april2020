package ru.alttabber.ludum.utils;

import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Vector2;
import ru.alttabber.ludum.gameobjects.Wall;
import ru.alttabber.ludum.gameobjects.units.Player;
import ru.alttabber.ludum.memory.GameController;

import java.util.ArrayList;
import java.util.List;

public class CollisionController {

    private List<Wall> impassableObjects;

    public CollisionController() {
        impassableObjects = new ArrayList<>();
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

    public void clear(){
        this.impassableObjects.clear();
    }

}
