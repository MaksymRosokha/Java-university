package com.rosokha.task4;

public class Mage extends GameCharacter {
    public Mage(String name) {
        super(name);
    }

    @Override
    public void attack() {
        System.out.println("Mage " + super.getName() + "is throwing a fireball");
    }
}
