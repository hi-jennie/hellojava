package org.example;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyFrame extends JFrame implements ActionListener {
    JButton button;
    JLabel dreamLabel;
    MyFrame(){
        dreamLabel = new JLabel();
        button = new JButton();

        ImageIcon dreamIcon = new ImageIcon("Dream.png");
        dreamLabel.setIcon(dreamIcon);
        dreamLabel.setVisible(false);
        dreamLabel.setBounds(0,0,500,500);


        button.setBounds(500,250,500,600);
        button.setBackground(Color.pink);
        button.setFocusable(false); // remove the blue border
        button.setBorder(BorderFactory.createEtchedBorder()); // add border
        button.addActionListener((ActionListener) this); // add action listener

        button.setText("what's matter with you?");
        button.setHorizontalTextPosition(JButton.CENTER);
        button.setVerticalTextPosition(JButton.TOP);
        button.setFont(new Font("Comic Sans",Font.BOLD,25));
        button.setForeground(Color.pink);

        ImageIcon icon = new ImageIcon("cat.png");
        button.setIcon(icon);
        button.setIconTextGap(10);


        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setSize(1000,1000);
        this.setResizable(false);
        this.setVisible(true);
        this.add(button);
        this.add(dreamLabel);
    }
    @Override
    // this method is called when the button is clicked
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==button){
            dreamLabel.setVisible(true);
        }
    }
}
