package com.rosokha.task4;

public class Airplane implements FlyingVehicle {
    private String vehicleModel;
    private boolean isFlyingMode = false;
    private double speed = 0;
    private double fuelLevel = 0;

    public Airplane(String vehicleModel, double fuelLevel) {
        this.vehicleModel = vehicleModel;
        this.fuelLevel = fuelLevel;
    }

    @Override
    public void takeOff() {
        if (this.isFlyingMode) {
            System.out.println(this.vehicleModel + " is taking off");
        } else {
            System.out.println(this.vehicleModel + " isn't in a flying mode");
        }
    }

    @Override
    public void land() {
        if (this.isFlyingMode) {
            System.out.println(this.vehicleModel + " lands");
        } else {
            System.out.println(this.vehicleModel + " isn't in a flying mode");
        }
    }

    @Override
    public void driveForward(double speed) {
        if (!this.isFlyingMode) {
            this.speed = speed;
            System.out.println(this.vehicleModel + " is driving forward with speed: " + speed);
        } else {
            System.out.println(this.vehicleModel + " isn't in a land mode");
        }
    }

    @Override
    public void applyBrakes() {
        if (!this.isFlyingMode) {
            System.out.println(this.vehicleModel + " is applying brakes");
        } else {
            System.out.println(this.vehicleModel + " isn't in a land mode");
        }
    }

    @Override
    public void switchToDriveMode() {
        this.isFlyingMode = false;
    }

    @Override
    public void switchToFlightMode() {
        this.isFlyingMode = true;
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

    public void setFuelLevel(double fuelLevel) {
        this.fuelLevel = fuelLevel;
    }
}
