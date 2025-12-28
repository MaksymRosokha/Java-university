package com.rosokha.task4;

public class Amphibian implements AmphibousVehicle {
    private String vehicleModel;
    private boolean isWaterMode = false;
    private double speed = 0;
    private double fuelLevel = 0;

    public Amphibian(String vehicleModel, double fuelLevel) {
        this.vehicleModel = vehicleModel;
        this.fuelLevel = fuelLevel;
    }

    public void switchToWaterMode() {
        this.isWaterMode = true;
    }

    public void switchToLandMode() {
        this.isWaterMode = false;
    }

    @Override
    public void driveForward(double speed) {
        if (!this.isWaterMode) {
            this.speed = speed;
            System.out.println(this.vehicleModel + " is driving forward with speed: " + speed);
        } else {
            System.out.println(this.vehicleModel + " isn't in a land mode");
        }
    }

    @Override
    public void applyBrakes() {
        if (!this.isWaterMode) {
            System.out.println(this.vehicleModel + " is applying brakes");
        } else {
            System.out.println(this.vehicleModel + " isn't in a land mode");
        }
    }

    @Override
    public void navigateOnWater(double headingDeg, double speed) {
        if (this.isWaterMode) {
            this.speed = speed;
            System.out.println(this.vehicleModel + " is navigating on water with speed: " + speed + " and heading deg: " + headingDeg);
        } else {
            System.out.println(this.vehicleModel + " isn't in a water mode");
        }
    }

    @Override
    public void anchor() {
        if (this.isWaterMode) {
            System.out.println(this.vehicleModel + " is dropping the anchor");
        } else {
            System.out.println(this.vehicleModel + " isn't in a water mode");
        }
    }

    @Override
    public void removeAnchor() {
        if (this.isWaterMode) {
            System.out.println(this.vehicleModel + " is removing the anchor");
        } else {
            System.out.println(this.vehicleModel + " isn't in a water mode");
        }
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
