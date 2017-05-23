package edu.mainRun.SimpleGUI.layoutsExample;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Example for Work with diff Swing Components (checkBox, RadioButton, TextField, Text Area
 * Created by serdyuk on 5/23/17.
 */
public class LotSwingComponents {
    private int i = 1;
    String[] listElem = {"first", "second", "third", "fourth", "fiveth"};

    private JFrame frame;
    private JPanel panel;
    private JButton button;
    private JTextField textField;
    private JTextField textField1;
    private JLabel label;
    private JScrollPane scrollPane;
    private JTextArea textArea;
    JCheckBox checkBox;
    JCheckBox checkBox1;
    JCheckBoxMenuItem boxMenuItem;
    JList<String> list;

    private void go() {
        frame = new JFrame("Swing Components");
        panel = new JPanel();
        label = new JLabel("This is Label for textField");
        button = new JButton("Get Text");
        button.addActionListener(new ButtonGetTextListener());
        button.addActionListener(new TextAreaListener());
        textField = new JTextField(20);
        textField.addActionListener(new FieldActionListener());
        textField1 = new JTextField("This is Text Field");
        textField.setText("this is my default text");
        checkBox = new JCheckBox("11");
        checkBox.addActionListener(new CheckBoxListener());
        checkBox1 = new JCheckBox("12");
        checkBox1.setSelected(true);

        list = new JList(listElem);
        list.addListSelectionListener(new ListListenerSample());

        scrollPane = new JScrollPane();
        textArea = new JTextArea(10, 20);
        textArea.setLineWrap(true);

        scrollPane.add(textArea);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        panel.add(textField);
        panel.add(label);
        panel.add(textField1);
        panel.add(button);
        panel.add(textArea);
        panel.add(scrollPane);
        panel.add(checkBox);
        panel.add(checkBox1);
        panel.add(list);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(panel);
        frame.setSize(600, 600);
        frame.setVisible(true);


        System.out.println(textField.getText());
    }

    public static void main(String[] args) {
        LotSwingComponents components = new LotSwingComponents();
        components.go();
    }

    class ButtonGetTextListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println(textField.getText());
            System.out.println(textField1.getText());
        }
    }

    class FieldActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            textField1.selectAll();
        }
    }

    class TextAreaListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            textArea.append(i + " Text in textField was: " + textField.getText() + "\n");
            i++;
        }
    }

    class CheckBoxListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (checkBox.isSelected()) {
                System.out.println("CheckBox is selected");
                textArea.append(i + " checkBox is: Selected" + "\n");
                i++;
            } else {
                textArea.append(i + " Text in textField was: noSelected" + "\n");
                i++;
            }
        }
    }

    class ListListenerSample implements ListSelectionListener {
        @Override
        public void valueChanged(ListSelectionEvent e) {
            if (e.getValueIsAdjusting()) {
                String selection = (String) list.getSelectedValue();
                System.out.println(selection);
                textArea.append(i + " Value from list is: " + list.getSelectedValue() + "\n");
                i++;
            }
        }
    }
}
