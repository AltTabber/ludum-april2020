package ru.alttabber.ludum.units;

import ru.alttabber.ludum.abstracts.GameObject;

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
}
