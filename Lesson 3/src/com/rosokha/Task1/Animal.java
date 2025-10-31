package com.rosokha.Task1;

public class Animal {
    private String name;
    private int age;

    public Animal(String name, int age){
        setAge(age);
        setName(name);
    }

    public void introduceYourself(){
        System.out.printf("Animal: %s has %d years old.\n", this.name, this.age);
    }

    public void voice(){
        System.out.println("Voice");
    }

    public void eat(){
        System.out.println("Eat");
    }

    public String getName(){
        return this.name;
    }

    public void setName(String name){
        this.name = name;
    }

    public int getAge(){
        return this.age;
    }

    public void setAge(int age){
        this.age = age;
    }
}
