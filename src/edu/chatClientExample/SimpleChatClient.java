package edu.chatClientExample;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Simple Chat client
 * Create GUI
 * Send data to server (WITH server)
 * Created by serdyuk on 6/9/17.
 */

public class SimpleChatClient {

    JTextArea incoming;
    JTextField outgoing;
    BufferedReader reader;
    Socket sock;
    PrintWriter writer;

    public static void main(String[] args) {
        SimpleChatClient chatClient = new SimpleChatClient();
        chatClient.go();
    }

    public void go() {
        JFrame frame = new JFrame("Ludicrously Chat Client");
        JPanel mainPanel = new JPanel();
        incoming = new JTextArea(15, 25);
        incoming.setLineWrap(true);
        incoming.setWrapStyleWord(true);
        incoming.setEditable(false);
        JScrollPane qSroller = new JScrollPane(incoming);
        qSroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        qSroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        outgoing = new JTextField(20);
        JButton sendButton = new JButton("Send");
        sendButton.addActionListener(new SendButtonLister());
        mainPanel.add(qSroller);
        mainPanel.add(outgoing);
        mainPanel.add(sendButton);
        setUpNetworking();

        Thread readerThread = new Thread(new IncomingReader());
        readerThread.start();

        frame.getContentPane().add(BorderLayout.CENTER, mainPanel);
        frame.setSize(400, 500);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    /*
    * We use socket for input and output threads
    * Output thread already used for for sending data,
    * but we add for him input stream.
    * That's why our object can receive data from server
    * */
    public void setUpNetworking() {
        try {
            sock = new Socket("127.0.0.1", 5000);
            InputStreamReader streamReader = new InputStreamReader(sock.getInputStream());
            reader = new BufferedReader(streamReader);
            writer = new PrintWriter(sock.getOutputStream());
            System.out.println("Networking Establishment");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private class SendButtonLister implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                writer.println(outgoing.getText());
                writer.flush();
            } catch (Exception ex) {
                ex.printStackTrace();
            }

            outgoing.setText("");
            outgoing.requestFocus();
        }
    }

    /*
    * It's work, what did Thread
    * in Method run() Thread go in loop
    * (while server response = null),
    * Read per once one row,
    * and add he in in scrollable text field
    * (use in end \n (new row))
    * */
    public class IncomingReader implements Runnable {
        @Override
        public void run() {
            String message;
            try {
                while ((message = reader.readLine()) != null) {
                    System.out.println("read from server " + message);
                    incoming.append(message + "\n");
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
}
