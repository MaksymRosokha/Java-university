package com.rosokha;

import com.rosokha.Task1.*;
import com.rosokha.Task2.*;
import com.rosokha.Task3.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Task 1");
        task1();
        System.out.println("\n\nTask 2");
        task2();
        System.out.println("\n\nTask 3");
        task3();
    }

    public static void task1(){
        List<Animal> animals = new ArrayList<>();
        animals.add(new Animal("Some animal", 14));
        animals.add(new Lion("Task1.Lion 1", 20));
        animals.add(new Elephant("Task1.Elephant 1", 45));

        for(Animal animal : animals){
            animal.introduceYourself();
            animal.voice();
            animal.eat();
            System.out.println("-------------------------------------");
        }
    }

    public static void task2(){
        Figure[] figures = new Figure[2];
        figures[0] = new Circle("Circle", 3.5);
        figures[1] = new Rectangle("Rectangle", 4, 6);

        for(int i = 0; i < figures.length; i++){
            figures[i].calcArea();
            figures[i].calcCircumference();
            figures[i].printInfo();
            System.out.println("-------------------------------------");
        }
    }

    public static void task3(){
        List<Employee> employees = new ArrayList<>();
        employees.add(new FullTimeEmployee("Alex", 5500.0, LocalDate.of(2017, 11, 23), new HomeAddress("Hew York")));
        employees.add(new ContractEmployee("Max", LocalDate.of(2012, 1, 28), new HomeAddress("Warsaw"), 160, 30));
        employees.add(new Intern("Jack", LocalDate.of(2025, 4, 7), new HomeAddress("Krakow")));

        for(Employee employee : employees){
            System.out.println(employee.getName() + " gets " + employee.calculateSalaries() + "$ per month");
        }
    }
}