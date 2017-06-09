package edu.threadsExamples.wrongWayInUserThreads;

/**
 * test class Bank account.
 * set money size. get money.
 * check money
 * Created by serdyuk on 6/9/17.
 */
public class BankAccount {
    public BankAccount(int balance) {
        this.balance = balance;
    }

    private int balance;

    public int getBalance() {
        return balance;
    }

    public void withDraw(int amount) {
        balance -= amount;
    }
}
