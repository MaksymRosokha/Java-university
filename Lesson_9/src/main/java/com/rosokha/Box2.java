package com.rosokha;

import java.util.ArrayList;
import java.util.List;

public class Box2<T extends Number> {
    private List<T> numbers;

    public Box2(){
        this.numbers = new ArrayList<>();
    }

    public void set(T value){
        this.numbers.add(value);
    }

    public T get(int index){
        return this.numbers.get(index);
    }

    public boolean isEmpty(){
        return this.numbers.isEmpty();
    }

    public void clear(){
        this.numbers.clear();
    }
}
