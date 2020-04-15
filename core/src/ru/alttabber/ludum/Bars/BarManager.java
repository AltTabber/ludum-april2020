package ru.alttabber.ludum.Bars;

import java.util.ArrayList;

public class BarManager {
    private int startX;
    private int numbOfBars;
    private ArrayList<Bar> barList;
    public BarManager(){
        numbOfBars = 0;
        barList = new ArrayList<Bar>();
        startX = 10;
    }
    public void addNewBar(Bar bar){
        barList.add(bar);
        numbOfBars++;
    }

    public ArrayList<Bar> getBarList(){
        return barList;
    }

    public int getYOfBar(int num){
        return  getYOfBar( num,480, 20);
    }

    public int getYOfBar(int numInList, int maxY, int hight){
        return maxY - hight*(1 + 2*numInList);
    }

    public int getStartX(){
        return startX;
    }

    public int getNumbOfBars(){
        return numbOfBars;
    }
}
