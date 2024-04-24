package org.example;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        // create an array list of Food

        Food food1 = new Food("Apple");
        Food food2 = new Food("Banana");
        Food food3 = new Food("Orange");

        Food[] refrigerator = {food1, food2, food3};

        System.out.println(refrigerator[0].name);
        System.out.println(refrigerator[1].name);


    }
}

