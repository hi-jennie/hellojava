package org.example;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Friend friend1 = new Friend("Rustin");
        Friend friend2 = new Friend("Turkey");

        // we can access the static attribute without creating an object but using the class name
        System.out.println(Friend.numberOfFriends);
    }
}

