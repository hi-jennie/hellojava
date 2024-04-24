package org.example;
public class Car {
    // attributes
    String name;
    int year = 2020;
    String colour = "blue";
    double price = 5000.00;

    Car(String name){
        this.name = name;
    }
    // methods
    void drive() {
        System.out.println("you drive the car");
    }
    void brake() {
        System.out.println("you step on the brakes");
    }
}