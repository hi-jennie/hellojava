package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

/**
 * @author rd_qinglin_mu
 * @description select a file
 * @单据标识
 * @date 2024/5/10 15:29
 **/
public class SelectFile extends JFrame implements ActionListener {
    JButton button;

    SelectFile(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new FlowLayout());

        button = new JButton("Select File");
        button.addActionListener(this);

        this.add(button);
        this.pack();
        this.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == button){
            JFileChooser fileChooser = new JFileChooser();
            // set the current directory of the file chooser,it means which directory the file chooser will open
            fileChooser.setCurrentDirectory(new File("C:\\Users\\Desktop"));
            // null is used to open the file chooser at the default location(in the center of the screen)
            int response = fileChooser.showOpenDialog(null);
            // int response = fileChooser.showSaveDialog(null);

            // JFileChooser.APPROVE_OPTION is a constant that is used to check if the user has selected a file or saved a file
            // it returns an integer value of 0
            if(response == JFileChooser.APPROVE_OPTION){
                // getSelectedFile() returns the file that the user selected
                File file = new File(fileChooser.getSelectedFile().getAbsolutePath());
                System.out.println(file);
            }
        }
    }
}
