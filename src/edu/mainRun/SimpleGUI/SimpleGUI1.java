package edu.mainRun.SimpleGUI;

import javax.swing.*;

/**
 * Simple gui example
 * Created by serdyuk on 5/14/17.
 */
public class SimpleGUI1 {
    public static void main(String[] args) {
        JFrame frame = new JFrame();

        JButton button = new JButton("Click me");

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(button);
        frame.setSize(300, 300);
        frame.setVisible(true);

//        public void changeIt() {
//            buttonRedraw.setText("I was clicked");
//        }
    }

}
