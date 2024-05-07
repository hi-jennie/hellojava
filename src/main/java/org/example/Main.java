package org.example;
import com.sun.security.jgss.GSSUtil;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        try {
            FileWriter writer = new FileWriter("Jennie.txt");
            writer.write("My name is Jennie\nI'm 24 years old");
            // append at the end of the file
            writer.append("Jennie's information");
            writer.close();
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
}

