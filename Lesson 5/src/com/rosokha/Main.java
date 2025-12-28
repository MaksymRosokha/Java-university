package com.rosokha;

import com.rosokha.task1.*;
import com.rosokha.task2.*;
import com.rosokha.task3.*;
import com.rosokha.task4.*;

import java.awt.datatransfer.FlavorEvent;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("------------------- TASK 1 ------------------- ");
        task1();
        System.out.println("\n------------------- TASK 2 ------------------- ");
        task2();
        System.out.println("\n------------------- TASK 3 ------------------- ");
        task3();
        System.out.println("\n------------------- TASK 4 ------------------- ");
        task4();
    }

    public static void task1(){
        List<Notification> notifications = new ArrayList<>();
        notifications.add(new EmailNotification("Maksym", "Hello, Dear Maksym..."));
        notifications.add(new PushNotification("Alex", "Cook dinner..."));
        notifications.add(new SMSNotification("Anna", "You have to pay 20$ for..."));

        for(Notification notification : notifications){
            notification.send();
        }
    }

    public static void task2(){
        List<Animal> animals = new ArrayList<>();
        animals.add(new Lion("Lion 1", 20));
        animals.add(new Elephant("Elephant 1", 45));

        for(Animal animal : animals){
            animal.introduceYourself();
            animal.voice();
            animal.eat();
            System.out.println("-------------------------------------");
        }
    }

    public static void task3(){
        FlyingCar flyingCar = new FlyingCar("Toyota flying car");
        com.rosokha.task3.AmphibousVehicle amphibousVehicle = new com.rosokha.task3.AmphibousVehicle("Mercedes amphibous vehicle");

        flyingCar.takeOff();
        flyingCar.switchToFlightMode();
        flyingCar.takeOff();
        flyingCar.land();
        flyingCar.switchToDriveMode();
        flyingCar.driveForward(200);
        flyingCar.applyBrakes();

        amphibousVehicle.navigateOnWater(50, 75);
        amphibousVehicle.switchToWaterMode();
        amphibousVehicle.navigateOnWater(50, 75);
        amphibousVehicle.anchor();
        amphibousVehicle.removeAnchor();
        amphibousVehicle.navigateOnWater(310, 75);
        amphibousVehicle.anchor();
        amphibousVehicle.removeAnchor();
        amphibousVehicle.switchToLandMode();
        amphibousVehicle.driveForward(125);
        amphibousVehicle.applyBrakes();
    }

    public static void task4(){
        List<Vehicle> vehicles = new ArrayList<>();
        vehicles.add(new Airplane("Aircraft", 2000));
        vehicles.add(new Amphibian("Amphibian", 900));
        vehicles.add(new Bus("School bus", 150));
        vehicles.add(new Car("BMW", 40));
        vehicles.add(new Ship("Yacht", 1400));

        for(Vehicle vehicle : vehicles){
            vehicle.start();
            vehicle.stop();
            System.out.println("Fuel level is: " + vehicle.getFulLevel());
            System.out.println();
        }
    }
}
