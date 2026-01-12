package com.rosokha.tasks_1_2;

import java.util.Random;

public class Car {
    private String brand;
    private String model;
    private boolean isEngineRunning;
    private double speed;
    private Engine engine;

    public Car(String brand, String model, double speed) {
        this.brand = brand;
        this.model = model;
        this.speed = speed;
    }

    public double turnOnEngine() {
        if (engine == null) {
            engine = new Engine(3);
        }
        engine.turnOn();
        this.isEngineRunning = true;
        return this.speed;
    }

    public void turnOffEngine() {
        engine.turnOff();
        this.isEngineRunning = false;
        this.speed = 0.0;
    }

    public static String getRandomColor() {
        Car.CarBodyColors c = new Car.CarBodyColors();
        return c.randomColor();
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public boolean isEngineRunning() {
        return isEngineRunning;
    }

    private class Engine {
        private int power;
        private boolean isRunning = false;

        Engine(int power) {
            setPower(power);
        }

        public void turnOn() {
            isRunning = true;
        }

        public void turnOff() {
            isRunning = false;
        }

        public int getPower() {
            return this.power;
        }

        public void setPower(int power) {
            this.power = Math.max(0, power);
        }
    }

    static class CarBodyColors {
        private static final String[] colors = {"red", "green", "blue", "orange", "black", "yellow"};

        public String randomColor() {
            Random random = new Random();
            return colors[random.nextInt(colors.length)];
        }
    }
}
