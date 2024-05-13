package org.example;

import java.util.Random;

//模拟彩票中奖号码
public class Main {

    public static void main(String[] args) {
        // generate a random number between 1 and 33

    }
    public static int[] redBall() {
        Random random = new Random(33);
        int[] red = new int[6];
        for (int i = 0; i < 6; i++) {
            red[i] = random.nextInt() + 1;
            if (i > 0) {
                for (int j = 0; j < i; j++) {
                    if (red[i] == red[j]) {
                        i--;
                        break;
                    }
                }
            }
        }
        return red;
    }
    public static int blueBall() {
        Random random = new Random(16);
        return random.nextInt() + 1;
    }
}

