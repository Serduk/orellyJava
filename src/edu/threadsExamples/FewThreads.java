package edu.threadsExamples;

/**
 * example how work few threads in onetime
 * Created by serdyuk on 6/9/17.
 */
public class FewThreads implements Runnable {
    public static void main(String[] args) {
        FewThreads threads = new FewThreads();

        Thread one = new Thread(threads);
        Thread two = new Thread(threads);

        one.setName("First Thread");
        two.setName("Second Thread");

        one.start();
        two.start();
    }

    @Override
    public void run() {
        for (int i = 0; i < 25; i++) {
            String threadName = Thread.currentThread().getName();
            System.out.println("Now working Thread: " + threadName);
        }
    }
}
