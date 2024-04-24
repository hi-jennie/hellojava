package org.example;

public class Garage {
    // park method accept a car parameter, it belongs to Car class
    // therefore we can't pass in parameter of other class
    void park(Car car){
        System.out.println("The "+car.name+" is parked in this garage");
    }
}
