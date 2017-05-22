package edu.mainRun.SimpleGUI;

import edu.mainRun.SimpleGUI.drawer.MyDrawPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * add 2d graphics, and image
 * Created by serdyuk on 5/19/17.
 */
public class SimpleGUI3C {
    JFrame jFrame;
    JButton buttonRedraw;
    JButton buttonSetLabel;
    JButton buttonMove;

//    int x = 70;
//    int y = 70;

    public static void main(String[] args) {
        SimpleGUI3C simpleGUI3C = new SimpleGUI3C();
        simpleGUI3C.go();

    }

    public void go() {
        jFrame = new JFrame();
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        buttonRedraw = new JButton("Change Color");
        buttonRedraw.addActionListener(new ColorListener());

        buttonSetLabel = new JButton("I am a Label!");
        buttonSetLabel.addActionListener(new LabelListener());

        buttonMove = new JButton("Move Me");

//        MyDrawPanel drawPanel = new MyDrawPanel(x, y);
        MyDrawPanel drawPanel = new MyDrawPanel();

        jFrame.getContentPane().add(BorderLayout.SOUTH, buttonRedraw);
        jFrame.getContentPane().add(BorderLayout.CENTER, drawPanel);
        jFrame.getContentPane().add(BorderLayout.WEST, buttonSetLabel);
        jFrame.setSize(300, 300);
        jFrame.setVisible(true);

//        for (int i = 0; i < 130; i++) {
//            int y = i;
//
//            drawPanel.repaint();
//            try {
//                Thread.sleep(50);
//            } catch (Exception e) {
//                System.out.println("Something Wrong with wait");
//            }
//        }


    }


    class LabelListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            buttonSetLabel.setText("Ouch!");
            if (buttonSetLabel.getText().equals("Ouch")) {
                buttonSetLabel.setText("I am a label");
            }
        }
    }

    class ColorListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            jFrame.repaint();
        }
    }

    class MoveBtnListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

        }
    }
}
