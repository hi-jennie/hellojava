package org.example;
import java.util.Random;

public class DiceRoller {
    // create a random object
    // it's a global variable, so all methods(include constructor) can access it
    Random random;
    int number;

    Diceroller() {
        random = new Random();
        roller();
    }
    void roller() {
        number = random.nextInt(6)+1;
        System.out.println(number);
    }
}
