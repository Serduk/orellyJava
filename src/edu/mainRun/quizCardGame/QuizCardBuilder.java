package edu.mainRun.quizCardGame;

import javax.swing.*;
import javax.swing.event.MenuListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * QuizCardBuilder
 * Created by serdyuk on 5/29/17.
 */
public class QuizCardBuilder {
    private JTextArea question;
    private JTextArea answer;
    private List<QuizCard> cardList;
    private JFrame frame;

    public static void main(String[] args) {
        QuizCardBuilder cardBuilder = new QuizCardBuilder();
        cardBuilder.go();
    }

    void go() {
        frame = new JFrame("Quiz Card Builder");
        JPanel mainPanel = new JPanel();
        Font bigFont = new Font("sanserif", Font.BOLD, 24);
        question = new JTextArea(6, 20);
        question.setLineWrap(true);
        question.setWrapStyleWord(true);
        question.setFont(bigFont);

        JScrollPane qScroller = new JScrollPane(answer);
        qScroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        qScroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);

        answer = new JTextArea(6, 20);
        answer.setLineWrap(true);
        answer.setWrapStyleWord(true);
        answer.setFont(bigFont);

        JScrollPane aScroller = new JScrollPane(answer);
        aScroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        aScroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);

        JButton nextButton = new JButton("Next Card");

        cardList = new ArrayList<QuizCard>();

        JLabel qLabel = new JLabel("Question");
        JLabel aLabel = new JLabel("Answer");

        mainPanel.add(qLabel);
        mainPanel.add(qScroller);
        mainPanel.add(aLabel);
        mainPanel.add(aScroller);
        mainPanel.add(nextButton);
        nextButton.addActionListener(new NextCardListener());
        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        JMenuItem newMenuItem = new JMenuItem("New");
        JMenuItem saveMenuItem = new JMenuItem("Save");
        newMenuItem.addActionListener(new NewMenuListener());

        saveMenuItem.addActionListener(new SaveMenuListener());
        fileMenu.add(newMenuItem);
        fileMenu.add(saveMenuItem);
        menuBar.add(fileMenu);
        frame.setJMenuBar(menuBar);
        frame.getContentPane().add(BorderLayout.CENTER, mainPanel);
        frame.setSize(500, 600);
        frame.setVisible(true);
    }

    public class NextCardListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            QuizCard card = new QuizCard(question.getText(), answer.getText());
            cardList.add(card);
            clearCard();
        }
    }

    public class NewMenuListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            cardList.clear();
            clearCard();
        }
    }

    public class SaveMenuListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            QuizCard quizCard = new QuizCard(question.getText(), answer.getText());
            cardList.add(quizCard);

            /*
            * Get new dialog window,
            * And program will stop on this row
            * while user choose "save Menu"
            * All navigation and other will execute JFileChooser class
            * */
            JFileChooser fileSave = new JFileChooser();
            fileSave.showSaveDialog(frame);
            safeFile(fileSave.getSelectedFile());
        }
    }

    public void clearCard() {
        question.setText("");
        answer.setText("");
        question.requestFocus();
    }

//    Method for writing file (get by listener worker in class (Save -> MenuListener))
//    Argument - its object "File", which save by user
    private void safeFile(File file) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(file));
            for (QuizCard card : cardList) {
                writer.write(card.getQuestion() + "/");
                writer.write(card.getAnswer() + "\n");
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
