package com.rosokha.Task3;

import java.time.LocalDate;

public class Intern extends Employee{
    public Intern(String name, Double salary, LocalDate hireDate, HomeAddress homeAddress) {
        super(name, salary, hireDate, homeAddress);
    }

    public Intern(String name, LocalDate hireDate, HomeAddress homeAddress) {
        super(name, hireDate, homeAddress);
    }

    @Override
    public double calculateSalaries() {
        return 1500;
    }
}
