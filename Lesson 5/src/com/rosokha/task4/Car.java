package com.rosokha.task4;

public class Car implements LandVehicle {
    private String vehicleModel;
    private double speed = 0;
    private double fuelLevel = 0;

    public Car(String vehicleModel, double fuelLevel) {
        this.vehicleModel = vehicleModel;
        this.fuelLevel = fuelLevel;
    }

    @Override
    public void driveForward(double speed) {
        this.speed = speed;
        System.out.println(this.vehicleModel + " is driving forward with speed: " + speed);
    }

    @Override
    public void applyBrakes() {
        System.out.println(this.vehicleModel + " is applying brakes");
    }

    @Override
    public void start() {
        System.out.println(this.vehicleModel + " is starting");
    }

    @Override
    public void stop() {
        System.out.println(this.vehicleModel + " is stopping");
    }

    @Override
    public double getSpeed() {
        return this.speed;
    }

    @Override
    public double getFulLevel() {
        return this.fuelLevel;
    }

    public String getVehicleModel() {
        return vehicleModel;
    }

    public void setVehicleModel(String vehicleModel) {
        this.vehicleModel = vehicleModel;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public double getFuelLevel() {
        return fuelLevel;
    }

    public void setFuelLevel(double fuelLevel) {
        this.fuelLevel = fuelLevel;
    }
}
