package org.example;
import com.sun.security.jgss.GSSUtil;

import java.io.File;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        // 相对路径：这个文件在这个project里就可以直接用文件名
        File file = new File("Jennie.txt");

        if(file.exists()){
            System.out.println("This file exists!");
            // other useful method
            System.out.println(file.getPath());
            System.out.println(file.getAbsoluteFile());
            System.out.println(file.isFile()); // return boolean
            file.delete(); // delete file after finishing this execution
        }
        else{
            System.out.println("This file doesn't exist!");
        }

    }
}

