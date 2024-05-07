package org.example;

import javax.swing.*;
import java.awt.*;
public class JennieFrame extends JFrame {
    JennieFrame() {
        this.setSize(500, 500);// set the size of the frame
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// set the close button to exit the program
        this.setVisible(true);// make this visible
        this.setTitle("first GUI of Jennie");// set the title of the frame
        this.setResizable(false);// make it so that the frame cannot be resized

        ImageIcon image = new ImageIcon("cat.png");// create an ImageIcon
        this.setIconImage(image.getImage());// set the icon of the frame
        this.getContentPane().setBackground(Color.pink);// set the background color of the frame

    }
}
