package edu.threadsExamples.wrongWayInUserThreads;

/**
 * example how we can loc and break threads in java
 * Created by serdyuk on 6/9/17.
 */
public class RyanAndMonikaJob implements Runnable {
    /*
    * We just have only one exemplar of class
    * its mean all thread will be go in this class
    * */
    BankAccount account = new BankAccount(100);

    public static void main(String[] args) {
        Runnable job = new RyanAndMonikaJob();
        Runnable job1 = new RyanAndMonikaJob();
        /*
        * Create 2 threads with one task Runnable
        * It's mean both threads will be work with one class
        * which stay in class runnable
        * */
        Thread one = new Thread(job);
        Thread two = new Thread(job);
        Thread synchronizedOne = new Thread(job1);
        Thread synchronizedTwo = new Thread(job1);

        one.setName("Ryan");
        two.setName("Monika");

        synchronizedOne.setName("synchronized ONE");
        synchronizedTwo.setName("synchronized TWO");

        one.start();
        two.start();

        synchronizedOne.start();
        synchronizedTwo.start();
    }

    /*
    * In method Run => Threads go in loop
    * And in each iteration try get money from account
    * After getting money from account he check balance again
    * He want make sure The limit is not exceeded
    * */
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            makeWithdrawal(10);
            if (account.getBalance() < 0) {
                System.out.println("Exceeding the limit");
            }
        }
    }

    private void makeWithdrawal(int amount) {
        /*
        * Check balance
        * if on account not enough money => sout message in console
        * If money enough => thread go in sleep.
        * Than renew thread him for complete transaction
        * */
        if (account.getBalance() >= amount) {
            System.out.println(Thread.currentThread().getName() + " Try get money");
            try {
                System.out.println(Thread.currentThread().getName() + " go to sleep");
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " Wake Up");
            account.withDraw(amount);
            System.out.println(Thread.currentThread().getName() + " Success complete transaction");
        } else {
            System.out.println(Thread.currentThread().getName() + " Not enough money on the account");
        }
    }

    /*
    * SYNCHRONIZED -> help us lock methods in Thread, and,
    * while first thread use method => Second Thread don't have access to method
    * Then, second Thread use method => First Threat don't have access to method
    * */
    private synchronized void correctMakeWithDrawal(int amount) {
        makeWithdrawal(amount);
    }
}
