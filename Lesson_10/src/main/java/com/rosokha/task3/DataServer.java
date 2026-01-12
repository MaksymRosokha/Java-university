package com.rosokha.task3;

import java.util.ArrayList;
import java.util.List;

public class DataServer {
    private List<Observer> observers;

    public DataServer() {
        observers = new ArrayList<>();
    }

    public void addObserver(Observer o) {
        this.observers.add(o);
    }

    public List<Observer> getObservers() {
        return this.observers;
    }
}
