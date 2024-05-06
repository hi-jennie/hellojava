package org.example;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Bicycle bike = new Bicycle();
        // in this case, the go method from the Vehicle class is called
        bike.go();
        // we can gain access to the parent class's methods and fields
        System.out.println(bike.speed);
    }
}

