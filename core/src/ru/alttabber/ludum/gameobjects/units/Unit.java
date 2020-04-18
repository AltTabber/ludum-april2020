package ru.alttabber.ludum.gameobjects.units;

import com.badlogic.gdx.math.Vector2;
import ru.alttabber.ludum.gameobjects.GameObject;

public abstract class Unit extends GameObject {

    protected int hits;
    protected int myDamage;
    protected int damage;

    Unit(){
        hits = 100;
        damage = myDamage = 0;
    }

    public void setHits(int hits)
    {
        this.hits = hits;
    }
    public int getHits(){return hits;}

    public void takeDamage(int damage){
        hits =- damage;
        if(hits < 0){
            hits = 0;
        }
    }

    public void setDamage(int weaponDamage)
    {
        damage = myDamage + weaponDamage;
    }
    public int giveDamage(){
        return damage;
    }

    boolean checkYourSelf(){
        if(hits == 0)
        {
            return false;
        }else{
            return true;
        }
    }

    public Vector2 getSpriteCenter(){
        return new Vector2(this.getX() + this.width/2, this.getY() + this.height/2);
    }
}
