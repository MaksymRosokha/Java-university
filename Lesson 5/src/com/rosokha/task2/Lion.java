package com.rosokha.task2;

public class Lion implements Animal {
    private String name;
    private int age;

    public Lion(String name, int age) {
        setName(name);
        setAge(age);
    }

    @Override
    public void introduceYourself() {
        System.out.printf("Lion: %s is %d years old.\n", this.name, this.age);
    }

    @Override
    public void voice(){
        System.out.println("Roar");
    }

    @Override
    public void eat(){
        System.out.println("Eating meat");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
