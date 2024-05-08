package org.example;

import org.example.FamilyMember;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Homepage extends JFrame implements ActionListener {
    JFrame frame = new JFrame();
    JButton button =  new JButton("click to see your cats");

    Homepage(){
        button.setBounds(150,150,200,100);
        button.setFocusable(false);
        button.addActionListener((ActionListener)this);
        button.setOpaque(true);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500,500);
        frame.setVisible(true);
        frame.setLayout(null);
        frame.add(button);
    }

    @Override
    public void actionPerformed(ActionEvent e){
        if (e.getSource() == button){
            frame.dispose();
            FamilyMember familyMember = new FamilyMember();
        }
    }
}
