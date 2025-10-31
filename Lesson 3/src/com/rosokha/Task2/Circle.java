package com.rosokha.Task2;

public class Circle extends Figure {
    private double radius;

    public Circle(String name, double radius) {
        super(name);
        setRadius(radius);
    }

    @Override
    public void calcArea() {
        setArea(Math.PI * this.radius * this.radius);
    }

    @Override
    public void calcCircumference() {
        setCircumference(2 * Math.PI * this.radius);
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }
}
