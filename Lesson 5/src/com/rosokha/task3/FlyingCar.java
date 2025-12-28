package com.rosokha.task3;

public class FlyingCar implements LandVehicle, AirVehicle {
    private String vehicleModel;
    private boolean isFlyingMode = false;

    public FlyingCar(String vehicleModel) {
        this.vehicleModel = vehicleModel;
    }

    public void switchToDriveMode() {
        this.isFlyingMode = false;
    }

    public void switchToFlightMode() {
        this.isFlyingMode = true;
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

    public String getVehicleModel() {
        return vehicleModel;
    }

    public void setVehicleModel(String vehicleModel) {
        this.vehicleModel = vehicleModel;
    }
}
