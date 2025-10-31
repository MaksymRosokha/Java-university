package com.rosokha.Task1;

public class Lion extends Animal {

    public Lion(String name, int age) {
        super(name, age);
    }

    @Override
    public void voice(){
        System.out.println("Roar");
    }

    @Override
    public void eat(){
        System.out.println("Eating meat");
    }
}
