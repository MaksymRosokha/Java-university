package com.rosokha.task3;

public class AmphibousVehicle implements LandVehicle, WaterVehicle {
    private String vehicleModel;
    private boolean isWaterMode = false;

    public AmphibousVehicle(String vehicleModel) {
        this.vehicleModel = vehicleModel;
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

    public String getVehicleModel() {
        return vehicleModel;
    }

    public void setVehicleModel(String vehicleModel) {
        this.vehicleModel = vehicleModel;
    }
}
