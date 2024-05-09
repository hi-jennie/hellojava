package org.example;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;

/**
 * @author rd_qinglin_mu
 * @description Slider
 * @单据标识
 * @date 2024/5/9 18:37
 **/
public class SliderDemo implements ChangeListener {
    JFrame frame;
    JPanel panel;
    JLabel label;
    JSlider slider;
    SliderDemo(){
        frame = new JFrame();
        panel = new JPanel();
        label = new JLabel();
        label.setFont(new Font("MV Boli",Font.PLAIN,25));

        //
        slider = new JSlider(0,100,50);
        slider.addChangeListener(this);

        slider.setPreferredSize(new Dimension(400,200));
        slider.setOrientation(SwingConstants.VERTICAL);
        // 设置那个一长条的滑轨
        slider.setPaintTrack(true);
        // 当你调用setPaintTicks(true)时，它会启用在滑块上绘制刻度标记。
        // 如果你调用setPaintTicks(false)，它会禁用在滑块上绘制刻度标记。
        slider.setPaintTicks(true);
        // 然后设置标记间隔
        slider.setMinorTickSpacing(10);
        slider.setMajorTickSpacing(20);

        slider.setPaintLabels(true);
        slider.setFont(new Font("MV Boli",Font.PLAIN,15));
        label.setFont(new Font("MV Boli",Font.PLAIN,25));
        // 注意getValue的位置，必须有value才能使用
        label.setText("C = "+slider.getValue());


        panel.add(slider);
        panel.add(label);
        frame.add(panel);
        frame.setSize(420,420);
        frame.setVisible(true);
    }
    @Override
    public void stateChanged(ChangeEvent e){
        label.setText("C = "+slider.getValue());
    }
}
