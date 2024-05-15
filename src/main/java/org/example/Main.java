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
        // 学会使用查表法，即将数字跟表产生一个一一对应的关系
        String[] uppercase = {"零","壹","贰","叁","肆","伍","陆","柒","捌","玖",};
        String result = "";
        for(int i=0;i<str.length();i++){
            // main step
            // 这行代码首先使用charAt方法获取字符串中的第i个字符，然后通过减去字符'0'的ASCII值，将字符型的数字转换为整数。
            // 字符'2'的ASCII值是50，字符'0'的ASCII值是48，所以'2'-'0'的结果就是2，这就实现了字符到整数的转换
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
