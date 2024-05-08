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
        JFrame frame = new JFrame();
        frame.setVisible(true);
        frame.setSize(500,500);
        // 设置了组件之间的水平和垂直间距为 10，以及组件的对齐方式为居中对齐
        frame.setLayout(new FlowLayout(FlowLayout.CENTER,10,10));

        frame.add(new Button("0"));
        frame.add(new Button("1"));
        frame.add(new Button("2"));
        frame.add(new Button("3"));
        frame.add(new Button("4"));
        frame.add(new Button("5"));
        frame.add(new Button("6"));
        frame.add(new Button("7"));
        frame.add(new Button("8"));
        frame.add(new Button("9"));
    }
}


