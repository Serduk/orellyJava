package edu.netExample.adviceClient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * Daily Advice Client
 * Work with net.
 * Connect to server and check some data
 * Created by serdyuk on 6/7/17.
 */
public class DailyAdviceClient {
    public void go() {
        try {
//            Create connection from socket with port 4242
            Socket socket = new Socket("127.0.0.1", 4242);

//            Add bufferedReader for streamReader for beat and faster reading data
            InputStreamReader streamReader = new InputStreamReader(socket.getInputStream());
            BufferedReader reader = new BufferedReader(streamReader);

            String advice = reader.readLine();
            System.out.println("Read Success: " + advice);

            reader.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        DailyAdviceClient client = new DailyAdviceClient();
        client.go();
    }
}
