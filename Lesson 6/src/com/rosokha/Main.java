package com.rosokha;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        //task1(scan);
        //task2(scan);
        task3(scan);
        scan.close();
    }

    public static void task1(Scanner scan) {
        int numerator = 0;
        int denominator = 0;
        double result = 0;

        while (true) {
            try {
                System.out.print("Enter numerator: ");
                numerator = Integer.parseInt(scan.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Numerator is incorrect");
                continue;
            }

            try {
                System.out.print("Enter denominator: ");
                denominator = Integer.parseInt(scan.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Denominator is incorrect");
                continue;
            }

            try {
                if (denominator == 0) {
                    throw new ArithmeticException("Exception: division by zero");
                }
                result = (double) numerator / denominator;
                break;
            } catch (ArithmeticException e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.println("Result: " + result);
    }

    public static void task2(Scanner scan) {
        while (true) {
            System.out.println("Enter text: ");
            String text = scan.nextLine();
            System.out.println("Enter char");
            char ch = ' ';
            try {
                ch = scan.nextLine().charAt(0);
            } catch (IndexOutOfBoundsException e) {
                System.out.println("Exception: you didn't enter the char");
                continue;
            }
            try {
                System.out.println("Index of the char: " + (getCharIndex(text, ch) + 1));
            } catch (NullPointerException e) {
                System.out.println(e.getMessage());
                continue;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
            break;
        }
    }

    public static int getCharIndex(String text, char ch) throws NullPointerException, IllegalArgumentException {
        if (text == null) {
            throw new NullPointerException("Exception: the text is null");
        }
        char[] textArray = text.toCharArray();
        for (int i = 0; i < textArray.length; i++) {
            if (textArray[i] == ch) {
                return i;
            }
        }
        throw new IllegalArgumentException("There aren't this char in the text");
    }

    public static void task3(Scanner scan) {
        while(true){
            int age = 0;
            System.out.print("Enter the age: ");
            try{
                age = Integer.parseInt(scan.nextLine());
            } catch(NumberFormatException e){
                System.out.println("Age must be a number");
                continue;
            }
            try{
                if (age < 0 || age > 120){
                    throw new IllegalArgumentException();
                }
            } catch (IllegalArgumentException e){
                System.out.println("Age can't be below 0 or above 120");
                continue;
            }
            try{
                registerUser(age);
                System.out.println("The user is of legal age");
            } catch (AgeTooLowException e) {
                System.out.println(e.getMessage());
            }
            break;
        }
    }

    public static void registerUser(int age) throws AgeTooLowException {
        if(age < 18){
            throw new AgeTooLowException("The user must be of legal age");
        }
    }
}
