package org.example;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Car car = new Car();
        Boat boat = new Boat();

        // Car[] racers = {car,boat};
        // because both car and boat belong to vehicle,so it's better to contain them in a Vehicle date type
        Vehicle[] racers = {car,boat};

        // we can use for-each loop to call go method one by one
        for(Vehicle x : racers) {
            x.go();
        }
    }
}

