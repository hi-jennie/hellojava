package org.example;
import com.sun.security.jgss.GSSUtil;

import java.awt.*;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;
import javax.sound.sampled.*;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.event.AncestorListener;



public class Main {
    public static void main(String[] args) {

        JOptionPane.showMessageDialog(null,"Hello,Jennie!","say hello",JOptionPane.PLAIN_MESSAGE);
        JOptionPane.showMessageDialog(null,"This is useless info","information",JOptionPane.INFORMATION_MESSAGE);
        JOptionPane.showMessageDialog(null,"really?","question",JOptionPane.QUESTION_MESSAGE);
        JOptionPane.showMessageDialog(null,"your computer has a Virus","Warning",JOptionPane.WARNING_MESSAGE);
        JOptionPane.showMessageDialog(null,"call tech support or else!!!","title",JOptionPane.ERROR_MESSAGE);

        // returns an integer which is the index of the option selected
        int answer = JOptionPane.showConfirmDialog(null,"DO you like code", "questionnaire",JOptionPane.YES_NO_OPTION);

        String name = JOptionPane.showInputDialog("What's your name?");

        String[] response = {"cat","dog","rabbit","fish"};
        ImageIcon icon = new ImageIcon("cat.png");

        // Option dialog returns an integer which is the index of the option selected
        JOptionPane.showOptionDialog(null,
                "my favorite animal",
                "favorite animal",
                JOptionPane.YES_NO_OPTION, // yes no option
                JOptionPane.INFORMATION_MESSAGE,
                icon,
                response,
                0);
    }
}


