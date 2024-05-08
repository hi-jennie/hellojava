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


public class Main {
    public static void main(String[] args) {
        JLabel label = new JLabel();
        ImageIcon image = new ImageIcon("cat.png");// create an ImageIcon
        label.setIcon(image);

        Border border = BorderFactory.createLineBorder(Color.pink,3);// create a border
        label.setBorder(border);// set the border of the label

        label.setText("Jennie likes cat very much");
        label.setHorizontalTextPosition(JLabel.CENTER); // set text LEFT, CENTER, RIGHT of image icon
        label.setVerticalTextPosition(JLabel.TOP); // set text TOP, CENTER, BOTTOM of image icon

        label.setForeground(Color.pink); // set the color of the text
        label.setFont(new Font("MV Boli",Font.PLAIN,50)); // set the font of the text

        label.setIconTextGap(-5); // set gap of text to image
        label.setBackground(Color.white); // set background color
        label.setOpaque(true); // display background color

        label.setVerticalAlignment(JLabel.CENTER); // set vertical position of icon+text within label
        label.setHorizontalAlignment(JLabel.CENTER); // set horizontal position of icon+text within label



        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.add(label); // add label to frame
        frame.pack(); // set size to fit all components
    }
}

