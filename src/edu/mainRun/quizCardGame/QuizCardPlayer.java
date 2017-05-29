package edu.mainRun.quizCardGame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * quiz card player
 * Created by serdyuk on 5/29/17.
 */
public class QuizCardPlayer {
    private JTextArea display;
    private JTextArea answer;
    private List<QuizCard> cardList;
    private QuizCard currentCard;
    private int currentCardIndex;
    private JFrame frame;
    private JButton nextButton;
    private boolean isShowAnswer;

    public static void main(String[] args) {
        QuizCardPlayer player = new QuizCardPlayer();
        player.go();
    }

    public void go() {
//        createGUI
        frame = new JFrame("Quiz Card Player");
        JPanel mainPanel = new JPanel();
        Font bigFont = new Font("sanserif", Font.BOLD, 24);

        display = new JTextArea(10, 20);
        display.setFont(bigFont);
        display.setLineWrap(true);
        display.setEditable(false);

        JScrollPane qScroller = new JScrollPane(display);
        qScroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        qScroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        nextButton = new JButton("Show Question");
        mainPanel.add(qScroller);
        mainPanel.add(nextButton);
        nextButton.addActionListener(new NextCardListener());

        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        JMenuItem loadMenuItem = new JMenuItem("Load Card Set");
        loadMenuItem.addActionListener(new OpenMenuListener());
        fileMenu.add(loadMenuItem);
        menuBar.add(fileMenu);
        frame.setJMenuBar(menuBar);
        frame.getContentPane().add(BorderLayout.CENTER, mainPanel);
        frame.setSize(640, 500);
        frame.setVisible(true);
    }

    class NextCardListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            /*
            * check boolean status "isShownAnswer";
            * wat is display now -> Question or Answer.
            * Depending on the result -> so action
            * */
            if (isShowAnswer) {
                display.setText(currentCard.getAnswer());
                nextButton.setText("Next Card");
                isShowAnswer = false;
            } else {
                //                show next question
                if (currentCardIndex < cardList.size()) {
                    showNextCard();
                } else {
                    display.setText("That was last card");
                    nextButton.setEnabled(false);
                }
            }
        }
    }

    class OpenMenuListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JFileChooser fileOpen = new JFileChooser();
            fileOpen.showOpenDialog(frame);
//            call the file window, who can choose file for opening
            loadFile(fileOpen.getSelectedFile());
        }
    }

    private void loadFile(File file) {
        cardList = new ArrayList<QuizCard>();
        try {
            /*
            * Create new buffered reader, connected with file reader.
            * Provide file for FileReader
            * */
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line = null;

            /*
            * Read each row per one run
            * set data to makeCard() method
            * which split it and make real Object QuizCard
            * and than add him to arrayList
            * */
            while ((line = reader.readLine()) != null) {
                makeCard(line);
            }
            reader.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        showNextCard();
    }

    private void makeCard(String lineToParse) {
        /*
        * Each text row much one flashCard
        * but we need split answer and question
        * So, that why we use method split().
        * one for question, second for answer
        * as delimeter we use "/"
        * */
        String[] result = lineToParse.split("/");
        QuizCard card = new QuizCard(result[0], result[1]);
        cardList.add(card);
        System.out.println("Made a card");
    }

    private void showNextCard() {
        currentCard = cardList.get(currentCardIndex);
        currentCardIndex++;
        display.setText(currentCard.getQuestion());
        nextButton.setText("Show Answer");
        isShowAnswer = true;
    }
}
