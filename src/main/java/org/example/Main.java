package org.example;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        // create a Car instance
        Car car = new Car("BMW");
        Car car1 = new Car("Tesla");

        // create a Garage instance
        Garage garage = new Garage();
        // call its park method, pass(only) a Car object named car
        garage.park(car);
    }
}

