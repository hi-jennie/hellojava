package org.example;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyFrame extends JFrame implements ActionListener {
    JComboBox comboBox;

    MyFrame(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new FlowLayout());

        String[] family = {"Jennie","Rustin","white","Turkey"};
        comboBox = new JComboBox(family);
        comboBox.addActionListener((ActionListener)this);

        // there are some relative method about comboBox
        // setEditable(true) will allow user to input their own value
        comboBox.setEditable(true);
        // get the number of items in the comboBox
        comboBox.getItemCount();
        // add an item to the comboBox
        comboBox.addItem("horse");
        comboBox.insertItemAt("rabbit",0);
        // set the selected item by the value
        comboBox.setSelectedItem("horse");
        // set the selected item by the index
        comboBox.setSelectedIndex(5);

        comboBox.removeItem("horse");
        comboBox.removeItemAt(0);
        // comboBox.removeAll();

        this.add(comboBox);
        this.setVisible(true);
        this.pack();
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==comboBox){
            // get the selected item and index
            System.out.println(comboBox.getSelectedItem());
            System.out.println(comboBox.getSelectedIndex());
        }

    }
}
