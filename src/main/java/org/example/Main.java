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
import javax.sound.sampled.*;


public class Main {
    public static void main(String[] args) throws IOException, UnsupportedAudioFileException, LineUnavailableException{
        Scanner scanner = new Scanner(System.in);

        File file = new File("audio.wav");
        AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
        Clip clip = AudioSystem.getClip();
        clip.open(audioStream);

        String response = "";

        while(!response.equals("Q")) {
            System.out.println("P = play,S = stop,R = reset,Q = quit");
            System.out.println("enter your choice");

            response = scanner.next();
            response = response.toUpperCase();

            switch (response) {
                case ("P"):
                    clip.start();
                    break;
                case ("S"):
                    clip.stop();
                    break;
                case ("R"):
                    clip.setMicrosecondPosition(0);
                    break;
                case ("Q"):
                    clip.close();
                    break;
                default:
                    System.out.println("Not a valid response");
            }
        }
    }
}

