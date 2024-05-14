package org.example;


public class Main {
    public static void main(String[] args) {
    int[] array = {1,2,3,4};
    System.out.println(arrToString(array));;

    }
    public static String arrToString(int[] arr) {
        if (arr == null) {
            return "";
        }
        if (arr.length == 0) {
            return "[]";
        }
        String result = "[";
        for(int i=0;i<arr.length;i++){
            if(i==arr.length-1){
                result = result+arr[i];
            }else {
                result = result+arr[i]+",";
            }
        }
        return result+"]";
    }
}
