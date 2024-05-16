package org.example;


import java.util.Scanner;

public class Main {
    String str;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("enter an int:");
        String str = scanner.next();
        String originalString = addZero(toUppercase(str));
        System.out.println(originalString);
        String[] unit = {"佰","拾","万","仟","佰","拾","元"};
        String finalString = "";

        for (int i = 0; i < 7; i++) {
            finalString = finalString+originalString.charAt(i)+unit[i];
        }
        System.out.println(finalString);
    }

    public static String toUppercase(String str){
        String[] uppercase = {"零","壹","贰","叁","肆","伍","陆","柒","捌","玖",};
        String result = "";
        for(int i=0;i<str.length();i++){
            int number = str.charAt(i)-'0';
            result = result+uppercase[number];
        }
        return result;
    }
    public static String addZero(String str){
        int count = 7-str.length();
        for (int i = 0; i < count; i++) {
            str = "零"+str;
        }
        return str;
    }
}
