package edu.examplesForRMIMiniServices;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Class for ServiceServerImpl
 *
 * TODO: Create dice as graphical object. They must shuffle, and change num on dice
 * Created by sserdiuk on 6/30/17.
 */
public class DiceService implements Service {
    JLabel label;
    JComboBox numOfDice;

    @Override
    public JPanel getGUIPanel() {
        JPanel panel = new JPanel();
        JButton button = new JButton("Roll em");
        String[] choises = {"1", "2", "3", "4", "5", "6"};
        numOfDice = new JComboBox(choises);
        label = new JLabel("Dice Values Here");
        button.addActionListener(new RollEmListener());

        panel.add(numOfDice);
        panel.add(button);
        panel.add(label);
        return panel;
    }

    private class RollEmListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String diceOuptput = "";
            String selection = (String) numOfDice.getSelectedItem();
            int numOfDiceToRoll = Integer.parseInt(selection);
            for (int i = 0; i < numOfDiceToRoll; i++) {
                int r = (int) ((Math.random() * 6) + 1);
                diceOuptput += (" " + r);
            }
            label.setText(diceOuptput);
        }
    }
}
