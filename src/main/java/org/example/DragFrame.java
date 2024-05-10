package org.example;

import javax.swing.*;

/**
 * @author rd_qinglin_mu
 * @description drag and drop
 * @单据标识
 * @date 2024/5/10 21:21
 **/
public class DragFrame extends JFrame {
    DragPanel dragPanel = new DragPanel();

    DragFrame(){
        this.add(dragPanel);
        this.setTitle("drag and drop demo");
        this.setSize(600,600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}
