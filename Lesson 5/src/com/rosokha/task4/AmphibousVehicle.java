package com.rosokha.task4;

public interface AmphibousVehicle extends LandVehicle, WaterVehicle{
    void switchToWaterMode();
    void switchToLandMode();
}
