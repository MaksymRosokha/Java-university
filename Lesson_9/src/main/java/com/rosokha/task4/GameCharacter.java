package com.rosokha.task4;

public abstract class GameCharacter {
    private String name;

    public GameCharacter(String name) {
        this.name = name;
    }

    public abstract void attack();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
