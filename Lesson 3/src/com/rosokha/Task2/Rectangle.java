package com.rosokha.Task2;

public class Rectangle extends Figure{
    private double sideA;
    private double sideB;

    public Rectangle(String name, double sideA, double sideB){
        super(name);
        setSideA(sideA);
        setSideB(sideB);
    }

    @Override
    public void calcArea(){
        setArea(this.sideA * this.sideB);
    }

    public void calcCircumference(){
        setCircumference((this.sideA + this.sideB) * 2);
    }

    public double getSideA() {
        return sideA;
    }

    public void setSideA(double sideA) {
        this.sideA = sideA;
    }

    public double getSideB() {
        return sideB;
    }

    public void setSideB(double sideB) {
        this.sideB = sideB;
    }
}
