package org.example;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("enter a string");
        String str = scanner.next();
        int len = str.length();
        String reverseStr = "";
        for(int i=len-1;i>=0;i--){
            reverseStr = reverseStr+str.charAt(i);
        }
        System.out.println(reverseStr);
    }
}
