package com.rosokha.task4;

public interface FlyingVehicle extends LandVehicle, AirVehicle {
    void switchToDriveMode();
    void switchToFlightMode();
}
