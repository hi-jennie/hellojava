package org.example;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyFrame extends JFrame implements ActionListener {
    JButton button;
    JTextField textField;
    MyFrame(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new FlowLayout());

        button = new JButton("submit");
        button.addActionListener((ActionListener) this); // add action listener

        textField = new JTextField();
        textField.setPreferredSize(new Dimension(200,30));
        textField.setBackground(Color.pink);
        textField.setFont(new Font("Consolas",Font.BOLD,20));
        textField.setForeground(Color.BLACK);
        textField.setText("username");

        this.add(button);
        this.add(textField);
        this.setSize(500,500);
        this.setVisible(true);
        // pack() method sizes the frame so that all its contents are at or above their preferred sizes.
        this.pack();
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==button){
            System.out.println("hello "+textField.getText());
            button.setEnabled(false);
            textField.setEditable(false);
        }
    }
}
