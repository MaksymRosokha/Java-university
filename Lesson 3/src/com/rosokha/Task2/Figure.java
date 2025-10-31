package com.rosokha.Task2;

public abstract class Figure {
    private String name;
    private double circumference;
    private double area;

    public Figure(String name){
        setName(name);
    }

    public abstract void calcArea();

    public abstract void calcCircumference();

    public void printInfo(){
        System.out.printf("%s\nCircumference: %f\nArea: %f\n", this.name, this.circumference, this.area);
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public double getCircumference() {
        return circumference;
    }

    public void setCircumference(double circumference) {
        this.circumference = circumference;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }
}
