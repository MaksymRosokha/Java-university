package com.rosokha;

import com.rosokha.task4.GameCharacter;
import com.rosokha.task4.Guild;
import com.rosokha.task4.Mage;
import com.rosokha.task4.Warrior;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args){
        //task1();
        //task2();
        //task3();
        task4();
    }

    public static void task1(){
        Box<Integer> box11 = new Box<>();
        System.out.println(box11.isEmpty());
        box11.set(12);
        System.out.println(box11.get());
        System.out.println(box11.isEmpty());
        box11.clear();
        System.out.println(box11.isEmpty());

        System.out.println("- - - - - - - - - -");

        Box<String> box12 = new Box<>();
        System.out.println(box12.isEmpty());
        box12.set("Hello World!");
        System.out.println(box12.get());
        System.out.println(box12.isEmpty());
        box12.clear();
        System.out.println(box12.isEmpty());
    }

    public static void task2(){
        Box2<Double> box21 = new Box2<>();
        System.out.println(box21.isEmpty());
        box21.set(12.2);
        box21.set(434.53);
        System.out.println(box21.get(1));
        System.out.println(box21.isEmpty());
        box21.clear();
        System.out.println(box21.isEmpty());

        System.out.println("- - - - - - - - - -");

        Box2<Integer> box22 = new Box2<>();
        System.out.println(box22.isEmpty());
        box22.set(16);
        box22.set(434);
        box22.set(93);
        System.out.println(box22.get(2));
        System.out.println(box22.isEmpty());
        box22.clear();
        System.out.println(box22.isEmpty());
    }

    public static void task3(){
        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        numbers.add(5);
        numbers.forEach(n -> System.out.print(n + " "));
        System.out.println();
        Swapper.swap(numbers, 1, 4);
        numbers.forEach(n -> System.out.print(n + " "));

        System.out.println("\n- - - - - - - - - -");

        List<String> strings = new ArrayList<>();
        strings.add("a");
        strings.add("b");
        strings.add("c");
        strings.add("d");
        strings.add("e");
        strings.forEach(s -> System.out.print(s + " "));
        System.out.println();
        Swapper.swap(strings, 2, 3);
        strings.forEach(s -> System.out.print(s + " "));
    }

    public static void task4(){
        Guild<GameCharacter> guild = new Guild<>();
        guild.add(new Warrior("Achilles"));
        guild.add(new Mage("Erebos"));
        guild.add(new Warrior("Alexander"));
        guild.add(new Mage("Blaze"));
        guild.add(new Warrior("Beowulf"));
        guild.add(new Mage("Morgath"));
        guild.add(new Warrior("Hector"));
        guild.add(new Mage("Hecate"));

        guild.triggerEveryoneAttack();
    }
}
