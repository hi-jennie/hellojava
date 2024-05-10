package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

/**
 * @author rd_qinglin_mu
 * @description
 * @单据标识
 * @date 2024/5/10 21:26
 **/
public class DragPanel extends JPanel {
    ImageIcon image = new ImageIcon("cat.png");
    final int WIDTH = image.getIconWidth();
    final int HEIGHT = image.getIconHeight();
    // 用于保存图像的左上角的位置
    Point imageCorner;
    // 用于保存鼠标点击的位置
    Point prePt;
    DragPanel(){
        imageCorner = new Point(0,0);
        ClickListener clickListener = new ClickListener();
        DragListener dragListener = new DragListener();

        this.addMouseListener(clickListener);
        this.addMouseMotionListener(dragListener);

    }
    public void paintComponent(Graphics g){
        // 保留容器中的原有组件
        super.paintComponent(g);
        //这个paintComponent方法的作用是在DragPanel的指定位置绘制一个图像。
        image.paintIcon(this,g,(int)imageCorner.x,(int)imageCorner.y);

    }

    private class ClickListener extends MouseAdapter {
        public void mousePressed(MouseEvent e){
            // 获取鼠标点击的位置
            prePt = e.getPoint();
        }
    }
    private class DragListener extends MouseMotionAdapter{
        public void mouseDragged(MouseEvent e){
            // 获取鼠标拖动的位置
            Point curPt = e.getPoint();
            // 计算图像的新位置
            // curPt.x-prePt.x和curPt.y-prePt.y计算的是鼠标在x轴和y轴上移动的距离。curPt是鼠标当前的位置，prePt是鼠标上一次的位置。
            // translate方法将这个移动的距离添加到imageCorner的当前位置上，从而得到图像新的位置。这样，当你拖动鼠标时，图像就会跟随鼠标移动。
            imageCorner.translate(curPt.x-prePt.x,curPt.y-prePt.y);
            // 更新prePt
            prePt = curPt;
            repaint();
        }

    }
}
