package edu.mainRun.SimpleGUI.layoutsExample;

import javax.swing.*;
import java.awt.*;

/**
 * Flow Layouts Example
 * Created by serdyuk on 5/23/17.
 */
public class FlowLayoutsExample {
    JFrame frame = new JFrame("My Fame");
    JButton button1, button2;
    JPanel panel;

    public void setUpFrame() {
        panel = new JPanel();
        panel.setBackground(Color.GREEN);
        button1 = new JButton("Button1");
        button2 = new JButton("button2");
        panel.add(button1);
        panel.add(button2);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(BorderLayout.EAST, panel);
//        frame.getContentPane().add(button2);
        frame.setSize(300, 300);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        FlowLayoutsExample layoutsExample = new FlowLayoutsExample();
        layoutsExample.setUpFrame();
    }
}
