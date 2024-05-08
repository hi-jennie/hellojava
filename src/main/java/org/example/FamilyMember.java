package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author rd_qinglin_mu
 * @description family member
 * @单据标识
 * @date 2024/5/8 16:32
 **/
public class FamilyMember {
    JFrame frame = new JFrame();
    FamilyMember(){
        JLabel label1 =  new JLabel();
        ImageIcon icon1 = new ImageIcon("cat.png");
        label1.setSize(1000,1000);
        label1.setIcon(icon1);
        label1.setText("Turkey");
        label1.setHorizontalAlignment(JLabel.CENTER);
        label1.setHorizontalTextPosition(JLabel.CENTER);
        label1.setVerticalTextPosition(JLabel.TOP);
        label1.setIconTextGap(20);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500,500);
        frame.setVisible(true);
        frame.setLayout(new GridLayout());
        frame.add(label1);
    }
}
