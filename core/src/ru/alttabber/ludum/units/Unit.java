package ru.alttabber.ludum.units;

import ru.alttabber.ludum.abstracts.GameObject;

public abstract class Unit extends GameObject {

    protected int hits;

    public void setHits(int hits){
        this.hits = hits;
    }
    public int getHits(){return hits;}
}
