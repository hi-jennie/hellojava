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
        JLabel label1 = new JLabel();
        label1.setBounds(0,0,200,200);
        label1.setOpaque(true);
        label1.setBackground(Color.pink);

        JLabel label2 = new JLabel();
        label2.setBounds(50,50,200,200);
        label2.setOpaque(true);
        label2.setBackground(Color.blue);

        JLabel label3 = new JLabel();
        label3.setBounds(100,100,200,200);
        label3.setOpaque(true);
        label3.setBackground(Color.cyan);

        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setBounds(0,0,500,500);
        // we can add the labels to different layers by setting the integer value of the specific layer
        layeredPane.add(label1, Integer.valueOf(0));
        layeredPane.add(label2, Integer.valueOf(1));
        layeredPane.add(label3, Integer.valueOf(2));

        // important step pass the layeredPane to the frame
        JFrame frame = new JFrame("JLayeredPane");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setSize(new Dimension(1000,1000));
        frame.add(layeredPane);
        // if we don't set the layout of the frame to null,
        // then we need to set bounds for the layeredPane manually
        frame.setLayout(null);
    }
}


