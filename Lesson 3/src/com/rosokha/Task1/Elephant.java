package com.rosokha.Task1;

public class Elephant extends Animal {

    public Elephant(String name, int age){
        super(name, age);
    }

    @Override
    public void voice(){
        System.out.println("Pvvvvvvvt!");
    }

    @Override
    public void eat(){
        System.out.println("Eating grass");
    }
}
