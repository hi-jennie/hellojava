package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author rd_qinglin_mu
 * @description color chooser panel
 * @单据标识
 * @date 2024/5/10 16:32
 **/
public class ColorChooser extends JFrame implements ActionListener {
    JButton button;
    JLabel label;
    ColorChooser(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new FlowLayout());

        button = new JButton("select a color");
        button.addActionListener(this);
        label = new JLabel();
        label.setText("the current color");
        label.setFont(new Font("MV Boli",Font.PLAIN,15));

        label.setOpaque(true);
        label.setForeground(Color.pink);
        label.setBackground(Color.black);
        this.add(button);
        this.add(label);
        this.add(button);
        this.add(label);
        this.pack();
        this.setVisible(true);
    }
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == button){
            JColorChooser colorChooser = new JColorChooser();
            Color color = JColorChooser.showDialog(null,"Pick a color",Color.pink);
            label.setForeground(color);
        }
    }

}
