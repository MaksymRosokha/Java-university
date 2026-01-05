package com.rosokha.task4;

public class Warrior extends GameCharacter{

    public Warrior(String name) {
        super(name);
    }

    @Override
    public void attack() {
        System.out.println("Warrior " + super.getName() + "is swinging a sword!");
    }
}
