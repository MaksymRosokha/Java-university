package com.rosokha.task4;

public interface WaterVehicle extends Vehicle {
    void navigateOnWater(double headingDeg, double speed);

    void anchor();

    void removeAnchor();
}
