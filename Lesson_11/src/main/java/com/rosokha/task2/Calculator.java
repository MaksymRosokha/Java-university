package com.rosokha.task2;

public class Calculator {

    public long add(int a, int b) {
        return a + b;
    }

    public double divide(int a, int b) throws ArithmeticException {
        if (b == 0) {
            throw new ArithmeticException();
        }
        return (double) a / b;
    }

    public boolean isEven(int n) {
        return n % 2 == 0;
    }
}
