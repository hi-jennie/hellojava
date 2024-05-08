package org.example;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyFrame extends JFrame implements ActionListener {
    JButton button;
    JCheckBox checkBox;
    MyFrame(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new FlowLayout());

        button = new JButton();
        button.setText("submit");
        button.addActionListener((ActionListener) this); // add action listener

        ImageIcon icon = new ImageIcon("cat.png");
        ImageIcon checkIcon = new ImageIcon("dream.png");

        checkBox = new JCheckBox();
        checkBox.setText("I'm not a rabbit");
        // remove the focus from the checkbox
        checkBox.setFocusable(false);
        checkBox.setFont(new Font("Consolas",Font.PLAIN,25));
        // set icon when not selected
        checkBox.setIcon(icon);
        // set icon when selected
        checkBox.setSelectedIcon(checkIcon);

        this.add(button);
        this.add(checkBox);
        this.setSize(500,500);
        this.setVisible(true);
        // pack() method sizes the frame so that all its contents are at or above their preferred sizes.
        this.pack();
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==button){
            // .isSelected() returns a boolean value
            System.out.println(checkBox.isSelected());
        }
    }
}
