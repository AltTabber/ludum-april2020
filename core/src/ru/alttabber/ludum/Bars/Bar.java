package ru.alttabber.ludum.Bars;

import com.badlogic.gdx.graphics.Color;

public abstract class Bar {
    protected int hight = 20;
    protected int length;
    protected int maxLength;
    protected Color color;
    protected Color emptyColor;
    Bar(){
        this(100);
    }

    Bar(int startValue){
        length=maxLength=startValue;
        color = new Color();
        emptyColor = new Color();
    }
    public Color getColor(){
        return color;
    }
    public Color getEmptyColor(){
        return emptyColor;
    }
    public int getHight(){
        return hight;
    }
    public int getMaxLength(){
        return maxLength;
    }
    public int getLength(){
        return length;
    }
    public void setLength(int length){ this.length = length;}
}
