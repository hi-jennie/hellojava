package org.example;
import com.sun.security.jgss.GSSUtil;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("Enter a whole number to divide");
            int x = scanner.nextInt();
            System.out.println("Enter a whole number to divide by");
            int y  = scanner.nextInt();

            int z = x/y;
            System.out.println("result"+z);
        }
        catch(ArithmeticException a){
            System.out.println("zero division error");
        }
        catch(InputMismatchException i){
            System.out.println("please enter a number");
        }
        catch(Exception e){
            System.out.println("something goes wrong");
        }

        finally {
            scanner.close();
            System.out.println("this block will always be executed");
        }
    }
}

