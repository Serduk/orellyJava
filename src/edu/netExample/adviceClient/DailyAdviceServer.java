package edu.netExample.adviceClient;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Set Up Server with examples, how it works
 * Created by serdyuk on 6/7/17.
 */
public class DailyAdviceServer {
    String[] adviceList = {"First message", "Second message", "Third message", "Fourth message", "Fives message"};

    public void go() {
        try {
//            Server setUp port for him like 4242
            ServerSocket serverSock = new ServerSocket(4242);

//            server go in neverending loop, for waiting client connections and work with them
            while (true) {
//                Method Accept block application while income some request, after what ->
//                return socket (on anonymous port) for work with client
                Socket sock = serverSock.accept();

//                Now we use connection Object Socket with client for create exemplar PrintWriter
//                Then we send him to print (println) string with answer;
//                Then we close socket because work process with client is closed
                PrintWriter writer = new PrintWriter(sock.getOutputStream());
                String advice = getAdvice();
                writer.println(advice);
                writer.close();
                System.out.println(advice);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private String getAdvice() {
        int random = (int) (Math.random() * adviceList.length);
        return adviceList[random];
    }

    public static void main(String[] args) {
        DailyAdviceServer dailyAdviceServer = new DailyAdviceServer();
        dailyAdviceServer.go();
    }
}
