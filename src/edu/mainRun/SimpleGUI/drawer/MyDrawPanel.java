package edu.mainRun.SimpleGUI.drawer;

import javax.swing.*;
import java.awt.*;

/**
 * Example for panel with drawing
 * Created by serdyuk on 5/19/17.
 */
public class MyDrawPanel extends JPanel {
//    public void paintComponent(Graphics graphics) {
//        graphics.setColor(Color.orange);
//        Image image = new ImageIcon("resources/img/desk.jpg").getImage();
//        graphics.fillRect(20, 50, 100, 100);
//        graphics.drawImage(image, 3, 4, this);
//    }
//
//    public void paintComponent(Graphics graphics) {
//        graphics.fillRect(0, 0, this.getWidth(), this.getHeight());
//
//        int red = randomizer(255);
//        int green = randomizer(255);
//        int blue = randomizer(255);
//
//        Color randomColor = new Color(red, green, blue);
//        graphics.setColor(randomColor);
//        graphics.fillOval(70, 70, 100, 100);
//    }

    public void paintComponent(Graphics graphics) {
        Graphics2D g2d = (Graphics2D) graphics;

        g2d.setColor(Color.WHITE);
        g2d.fillRect(0, 0, this.getWidth(), this.getHeight());

        Color startColor = new Color(randomizer(255), randomizer(255), randomizer(255));
        Color endColor = new Color(randomizer(255), randomizer(255), randomizer(255));

        GradientPaint gradientPaint = new GradientPaint(70, 70, startColor, 150, 150, endColor);
        g2d.setPaint(gradientPaint);
        g2d.fillOval(randomizer(100), randomizer(100), 100, 100);
    }

    private int randomizer(int size) {
        return (int) (Math.random() * size);
    }
}
