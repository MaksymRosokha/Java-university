package com.rosokha.task4;

public class Ship implements WaterVehicle{
    private String vehicleModel;
    private double speed = 0;
    private double fuelLevel = 0;

    public Ship(String vehicleModel, double fuelLevel) {
        this.vehicleModel = vehicleModel;
        this.fuelLevel = fuelLevel;
    }

    @Override
    public void navigateOnWater(double headingDeg, double speed) {
        this.speed = speed;
        System.out.println(this.vehicleModel + " is navigating on water with speed: " + speed + " and heading deg: " + headingDeg);
    }

    @Override
    public void anchor() {
        System.out.println(this.vehicleModel + " is dropping the anchor");
    }

    @Override
    public void removeAnchor() {
        System.out.println(this.vehicleModel + " is removing the anchor");
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
