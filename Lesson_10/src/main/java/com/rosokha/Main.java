package com.rosokha;

import com.rosokha.task3.DataServer;
import com.rosokha.task3.Observer;
import com.rosokha.task4.PasswordService;
import com.rosokha.tasks_1_2.Car;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        //task_1_2();
        //task3();
        task4();
    }

    public static void task_1_2(){
        Car car = new Car("Toyota", "Corolla", 60.0);

        System.out.println("Engine running (before): " + car.isEngineRunning());

        car.turnOnEngine();
        System.out.println("Engine running (after ON): " + car.isEngineRunning());
        System.out.println("Speed: " + car.getSpeed());

        car.turnOffEngine();
        System.out.println("Engine running (after OFF): " + car.isEngineRunning());
        System.out.println("Speed: " + car.getSpeed());
    }

    public static void task3() {
        DataServer dataServer = new DataServer();
        String data = "Hello, World!";
        Observer observer1 = new Observer() {
            @Override
            public void updated(String data) {
                System.out.println(data);
            }
        };
        Observer observer2 = new Observer() {
            @Override
            public void updated(String data) {
                Path pathToFile = Paths.get("data", "storage.txt");
                File file = pathToFile.toFile();
                try (BufferedWriter bw = new BufferedWriter(new FileWriter(file.getPath(), true))) {
                    bw.write(data);
                    bw.newLine();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        };
        dataServer.addObserver(observer1);
        dataServer.addObserver(observer2);

        dataServer.getObservers().forEach(o -> o.updated(data));
    }

    public static void task4() {
        List<String> passwords = new ArrayList<>();
        passwords.add("Hello");
        passwords.add("43aBBBm@444");
        passwords.add("1234567890");
        passwords.add("asl;kjdfLLL!343443");
        PasswordService passwordService = new PasswordService();

        passwords.forEach(p -> {
            if (passwordService.isStrong(p)) {
                System.out.println(p + " is a strong password");
            } else {
                System.out.println(p + " is a week password");
            }
        });
    }
}
