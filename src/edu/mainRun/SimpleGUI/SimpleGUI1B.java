package edu.mainRun.SimpleGUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * GUI with listeners
 * Created by serdyuk on 5/14/17.
 */
public class SimpleGUI1B implements ActionListener {
    private JButton button;


    private void go() {
        JFrame frame = new JFrame();
        button = new JButton("Click me");
        Font bigFont = new Font("serif", Font.BOLD, 28);
        button.setFont(bigFont);

        button.addActionListener(this);

        frame.getContentPane().add(button);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 300);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (button.getText().equals("I've been clicked")) {
            button.setText("Click me again!!!");
        } else {
            button.setText("I've been clicked");
        }
    }

    public static void main(String[] args) {
        SimpleGUI1B simpleGUI1B = new SimpleGUI1B();
        simpleGUI1B.go();
    }
}
