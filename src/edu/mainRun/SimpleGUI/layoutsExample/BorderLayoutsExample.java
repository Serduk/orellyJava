package edu.mainRun.SimpleGUI.layoutsExample;

import javax.swing.*;
import java.awt.*;

/**
 * GUI Example for Border layout
 * Created by serdyuk on 5/23/17.
 */
public class BorderLayoutsExample {
    JFrame jFrame = new JFrame();

    JButton buttonNorth = new JButton("North");
    JButton buttonSouth = new JButton("South");
    JButton buttonWest = new JButton("West");
    JButton buttonEast = new JButton("East");
    JButton buttonCenter = new JButton("Center");

    public void setUpGUI() {
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.getContentPane().add(BorderLayout.WEST, buttonWest);
        jFrame.getContentPane().add(BorderLayout.EAST, buttonEast);
        jFrame.getContentPane().add(BorderLayout.SOUTH, buttonSouth);
        jFrame.getContentPane().add(BorderLayout.NORTH, buttonNorth);
        jFrame.getContentPane().add(BorderLayout.CENTER, buttonCenter);
        jFrame.setSize(300, 300);
        jFrame.setVisible(true);
    }

    public static void main(String[] args) {
        BorderLayoutsExample borderLyaoutsExample = new BorderLayoutsExample();
        borderLyaoutsExample.setUpGUI();
    }

}
