package org.example;
import com.sun.security.jgss.GSSUtil;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        try {
            FileReader reader = new FileReader("Jennie.txt");
            int data = reader.read();
            while (data != -1) {
                // When you cast this integer to a char, it gets converted to the corresponding character as per the ASCII table.
                // For example, if data is 65, (char) data would be 'A', because 65 is the ASCII value for 'A'.
                System.out.print((char) data);
                data = reader.read();
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
}

