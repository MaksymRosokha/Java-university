package com.rosokha.Task3;

import java.time.LocalDate;

public class FullTimeEmployee extends Employee {
    public FullTimeEmployee(String name, Double salary, LocalDate hireDate, HomeAddress homeAddress) {
        super(name, salary, hireDate, homeAddress);
    }

    public FullTimeEmployee(String name, LocalDate hireDate, HomeAddress homeAddress) {
        super(name, hireDate, homeAddress);
    }

    @Override
    public double calculateSalaries() {
        return getSalary();
    }
}
