package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;


/**
 * @author rd_qinglin_mu
 * @description menubar
 * @单据标识
 * @date 2024/5/10 13:48
 **/
public class MenuBar extends JFrame implements ActionListener {
    JMenuBar menuBar;
    JMenu fileMenu;
    JMenu editMenu;
    JMenu helpMenu;
    JMenuItem loadItem;
    JMenuItem saveItem;
    JMenuItem exitItem;

    MenuBar(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500,500);
        this.setLayout(new FlowLayout());

        menuBar = new JMenuBar();
        fileMenu = new JMenu("file");
        editMenu = new JMenu("edit");
        helpMenu = new JMenu("help");


        loadItem = new JMenuItem("load");
        saveItem = new JMenuItem("save");
        exitItem = new JMenuItem("exit");
        loadItem.addActionListener(this);
        saveItem.addActionListener(this);
        exitItem.addActionListener(this);

        fileMenu.setMnemonic(KeyEvent.VK_F);// Alt+F for file
        editMenu.setMnemonic(KeyEvent.VK_E);// Alt+E for edit
        helpMenu.setMnemonic(KeyEvent.VK_H);// Alt+H for help
        loadItem.setMnemonic(KeyEvent.VK_L);// Alt+L for load
        saveItem.setMnemonic(KeyEvent.VK_S);// Alt+S for save
        exitItem.setMnemonic(KeyEvent.VK_X);// Alt+E for exit


        fileMenu.add(loadItem);
        fileMenu.add(saveItem);
        fileMenu.add(exitItem);

        menuBar.add(fileMenu);
        menuBar.add(editMenu);
        menuBar.add(helpMenu);
        this.add(menuBar);
        this.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==loadItem){
            System.out.println("loadItem");
        }
        if(e.getSource()==saveItem){
            System.out.println("saveItem");
        }
        if(e.getSource()==exitItem){
            System.out.println("exitItem");
        }
    }
}
