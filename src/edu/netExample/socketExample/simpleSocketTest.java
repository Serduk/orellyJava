package edu.netExample.socketExample;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Simple socketWork
 * Example, how work socket
 * Created by serdyuk on 6/7/17.
 */
public class simpleSocketTest {
    public static void main(String[] args) {
        Socket chatSocket;
        InputStreamReader streamReader;
        BufferedReader reader;

        PrintWriter writer;


        String message;

        try {
            chatSocket = new Socket("127.0.0.1", 7000);
            streamReader = new InputStreamReader(chatSocket.getInputStream());
            reader = new BufferedReader(streamReader);

            message = reader.readLine();

            System.out.println(message);


            writer = new PrintWriter(chatSocket.getOutputStream());
            writer.println("Message: ");
            writer.print(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
