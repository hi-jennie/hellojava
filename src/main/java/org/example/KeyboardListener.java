package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * @author rd_qinglin_mu
 * @description KeyListener
 * @单据标识
 * @date 2024/5/10 17:45
 **/
public class KeyboardListener extends JFrame implements KeyListener {
    JLabel label;
    KeyboardListener(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500,500);
        this.setLayout(null);
        this.addKeyListener(this);

        label = new JLabel();
        label.setBounds(0,0,100,100);
        label.setOpaque(true);
        label.setBackground(Color.pink);

        this.add(label);
        this.setVisible(true);
    }
    @Override
    public void keyTyped(KeyEvent e){
        switch (e.getKeyChar()){
            case 'a':label.setLocation(label.getX()-10,label.getY());
                break;
            case 'd':label.setLocation(label.getX()+10,label.getY());
                break;
            case 's':label.setLocation(label.getX(),label.getY()+10);
                break;
            case 'w':label.setLocation(label.getX(),label.getY()-10);
                break;
        }
    }

    @Override
    public void keyPressed(KeyEvent e){
        switch (e.getKeyCode()){
            // KeyEvent.VK_A是Java的一个常量，表示键盘上的"A"键。KeyEvent类中的每个VK_常量都对应一个键盘按键。这些常量通常用于键盘事件处理，如键盘按键的监听
            case KeyEvent.VK_A:label.setLocation(label.getX()-10,label.getY());
                break;
            case KeyEvent.VK_D:label.setLocation(label.getX()+10,label.getY());
                break;
            case KeyEvent.VK_S:label.setLocation(label.getX(),label.getY()+10);
                break;
            case KeyEvent.VK_W:label.setLocation(label.getX(),label.getY()-10);
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e){
        //
        System.out.println("you released key char " + e.getKeyChar());
        //System.out.println("you released key code " + e.getKeyCode());
    }
}
