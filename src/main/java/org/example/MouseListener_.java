package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseListener;

/**
 * @author rd_qinglin_mu
 * @description mouselistener
 * @单据标识
 * @date 2024/5/10 20:49
 **/
public class MouseListener_ extends JFrame implements MouseListener {
    JLabel label;
    public MouseListener_() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new FlowLayout());
        this.setSize(500,500);
        label = new JLabel();
        label.setText("click me to change color");
        label.setFont(new Font("MV Boli",Font.BOLD,25));
        label.setOpaque(true);
        label.addMouseListener(this);
        label.setBackground(Color.pink);

        this.add(label);
        this.pack();
        this.setVisible(true);
    }


    @Override
    public void mouseClicked(java.awt.event.MouseEvent e) {
        // click the mouse(press and release)
        System.out.println("Mouse Clicked");
        label.setBackground(Color.blue);
    }

    @Override
    public void mousePressed(java.awt.event.MouseEvent e) {
        // press the mouse only
        System.out.println("Mouse Pressed");
        label.setBackground(Color.yellow);
    }

    @Override
    public void mouseReleased(java.awt.event.MouseEvent e) {
        // release the mouse only
        System.out.println("Mouse Released");
        label.setBackground(Color.red);
    }

    @Override
    public void mouseEntered(java.awt.event.MouseEvent e) {
        // mouse entered the label but not clicked
        System.out.println("Mouse Entered");
        label.setBackground(Color.green);
    }

    @Override
    public void mouseExited(java.awt.event.MouseEvent e) {
        // mouse exited the label
        System.out.println("Mouse Exited");
        label.setBackground(Color.pink);
    }
}
