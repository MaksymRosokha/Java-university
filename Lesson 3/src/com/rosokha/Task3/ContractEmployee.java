package com.rosokha.Task3;

import java.time.LocalDate;

public class ContractEmployee extends Employee {
    private double numberOfHours;
    private double salaryPerHour;

    public ContractEmployee(String name, Double salary, LocalDate hireDate, HomeAddress homeAddress, double numberOfHours, double salaryPerHour) {
        super(name, salary, hireDate, homeAddress);
        setNumberOfHours(numberOfHours);
        setSalaryPerHour(salaryPerHour);
        calculateSalaries();
    }

    public ContractEmployee(String name, LocalDate hireDate, HomeAddress homeAddress, double numberOfHours, double salaryPerHour) {
        super(name, hireDate, homeAddress);
        setNumberOfHours(numberOfHours);
        setSalaryPerHour(salaryPerHour);
        calculateSalaries();
    }

    @Override
    public double calculateSalaries() {
        super.setSalary(this.numberOfHours * this.salaryPerHour);
        return super.getSalary();
    }

    public double getNumberOfHours() {
        return numberOfHours;
    }

    public void setNumberOfHours(double numberOfHours) {
        this.numberOfHours = numberOfHours;
    }

    public double getSalaryPerHour() {
        return salaryPerHour;
    }

    public void setSalaryPerHour(double salaryPerHour) {
        this.salaryPerHour = salaryPerHour;
    }
}
