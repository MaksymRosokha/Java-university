package com.rosokha;

import java.util.Random;
import java.util.Scanner;

public class Lesson1 {
    public static void main(String[] args) {
        //task1();
        //task2();
        //task3();
        //task4();
        //task5();
        //task6();
        //task7();
        task8();
    }

    public static void task1() {
        String str = "Java to wspaniały język";
        System.out.println(str);
        String newStr = str.substring(0, str.indexOf("wspaniały")) +
                "najlepszy" +
                str.substring(str.indexOf("wspaniały") + 9);
        System.out.println(newStr);
    }

    public static void task2() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter a sentence: ");
        String str = scan.nextLine();
        String newStr = str.toUpperCase();
        String[] strs = newStr.split(" ");
        int[] numbers = new int[strs.length];

        for (int i = 0; i < strs.length; i++) {
            for (int j = 0; j < strs.length; j++) {
                if (strs[i].equals(strs[j])) {
                    numbers[i] += 1;
                }
            }
        }

        for (int i = 0; i < strs.length; i++) {
            System.out.println(numbers[i] + " " + strs[i]);
        }

        scan.close();
    }

    public static void task3() {
        StringBuilder sb = new StringBuilder();
        Scanner scan = new Scanner(System.in);
        while (true) {
            String str = scan.nextLine();
            if (str.trim().isEmpty()) {
                break;
            }
            sb.append(str + " ");
        }
        System.out.println(sb.toString());
        scan.close();
    }

    public static void task4() {
        Scanner scan = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        System.out.println("Enter some phrase: ");
        sb.append(scan.nextLine());
        System.out.println(sb);
        sb.reverse();
        System.out.println(sb);
        sb.insert(0, "START-");
        System.out.println(sb);
        sb.delete(2, 5);
        System.out.println(sb);
        sb.delete(1, 4);
        sb.insert(1, "XYZ");
        System.out.println(sb);

        scan.close();
    }

    public static void task5() {
        String s = "";
        Long time = System.nanoTime();
        for (int i = 0; i < 100000; i++) {
            s += "X";
        }
        System.out.println("String:        " + (System.nanoTime() - time));
        StringBuilder sb = new StringBuilder();
        time = System.nanoTime();
        for (int i = 0; i < 100000; i++) {
            sb.append("X");
        }
        System.out.println("StringBuilder: " + (System.nanoTime() - time));
    }

    public static void task6() {
        char[] vowels = new char[5];
        vowels[0] = 'a';
        vowels[1] = 'e';
        vowels[2] = 'o';
        vowels[3] = 'i';
        vowels[4] = 'u';

        Scanner scan = new Scanner(System.in);
        System.out.print("Enter something: ");
        String str = scan.nextLine();
        for (int i = 0; i < str.length(); i++) {
            for (int j = 0; j < vowels.length; j++) {
                if (str.charAt(i) == vowels[j]) {
                    System.out.println((i + 1) + " " + str.charAt(i));
                    break;
                }
            }
        }

        scan.close();
    }

    public static void task7() {
        int[] arr = new int[10];
        for (int i = 0, j = 9; i < arr.length; i++, j--) {
            arr[i] = j;
            System.out.println(arr[i]);
        }
    }

    public static void task8() {
        Random rand = new Random();
        int[] arr = new int[10];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rand.nextInt(-20, 20);
            System.out.print(arr[i] + "   ");
        }
        System.out.println();

        int min = arr[0];
        int max = arr[0];
        for (int i : arr) {
            if (i < min) {
                min = i;
            } else if (i > max) {
                max = i;
            }
        }
        System.out.printf("Min: %d; Max: %d;\n", min, max);

        int sum = 0;
        for (int i : arr) {
            sum += i;
        }
        double average = (double) sum / arr.length;
        System.out.println("Average: " + average);

        int lessThanAvr = 0;
        int biggerThanAvr = 0;
        for (int i : arr) {
            if (i < average) {
                lessThanAvr++;
            } else if (i > average) {
                biggerThanAvr++;
            }
        }
        System.out.println("Numbers which less than average:  " + lessThanAvr);
        System.out.println("Numbers which bigger than average: " + biggerThanAvr);

        int[] repeatedNumbers = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (arr[i] == arr[j]) {
                    repeatedNumbers[i]++;
                }
            }
        }

        for (int i = 0; i < arr.length; i++) {
            System.out.println("Number " + arr[i] + " repeats " + repeatedNumbers[i] + " times");
        }
    }
}