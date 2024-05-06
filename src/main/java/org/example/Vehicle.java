package org.example;

public class Vehicle {
    // this attribute is common to all vehicles including bicycles and cars
    double speed;

    void go(){
        System.out.println("This vehicle is moving");
    }

    void stop(){
        System.out.println("This vehicle is stopped");
    }
}
