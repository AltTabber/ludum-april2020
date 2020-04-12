package ru.alttabber.ludum.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UniqueArrayList<E> {

    List<E> list;

    public UniqueArrayList() {
        list = new ArrayList<>();
    }

    public void add(E element){
        if(!list.contains(element)){
            list.add(element);
        }
    }

    public E get(int index){
        return list.get(index);
    }

    public E getLast(){
        if(list.isEmpty()) return null;
        return list.get(list.size() - 1);
    }

    public boolean remove(E element){
        return list.remove(element);
    }

    public boolean isEmpty(){
        return list.isEmpty();
    }

    public boolean contains(E element){
        return list.contains(element);
    }

    @Override
    public String toString() {
        return "UniqueArrayList{" +
                "list=" + Arrays.toString(list.toArray()) +
                '}';
    }
}
