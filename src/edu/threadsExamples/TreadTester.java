package edu.threadsExamples;

/**
 * Main runnable class for checking Threads
 * Created by serdyuk on 6/7/17.
 */
public class TreadTester {
    public static void main(String[] args) {
        /*Deliver exemplar MyRunnable to interface Runnable,
        in constructor Thread
        Thats why program will now which method will be first*/
        Runnable threadJob = new MyRunnable();
        Thread myThread = new Thread(threadJob);

        /*You didn't receive new executable Thread while don't use START method in Thread*/
        myThread.start();
        System.out.println("Return to method main");
    }
}
