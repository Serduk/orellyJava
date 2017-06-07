package edu.threadsExamples;

/**
 * First test class for check and show examples how work Threads
 * Created by serdyuk on 6/7/17.
 */
public class MyRunnable implements Runnable {
    @Override
    public void run() {
        go();
    }
    public void go() {
        try {
            Thread.sleep(2000);
            System.out.println("Sleep 2000ms success");
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        sayHi();
    }

    private void sayHi() {
        System.out.println("Hi");
    }
}
