package org.example;


public class Human {
    String name;
    int age;
    double weight;

    Human(String name, int age, double weight) {
        this.name = name;
        this.age = age;
        this.weight = weight;
    }

    // how to gain access to the attributes of the class
    void eat() {
        System.out.println(this.name+" is eating");
    }
}
