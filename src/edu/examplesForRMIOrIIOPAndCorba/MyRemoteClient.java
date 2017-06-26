package edu.examplesForRMIOrIIOPAndCorba;

import java.rmi.Naming;

/**
 * Client for Using RMI
 * Full workable version
 * Created by sserdiuk on 6/26/17.
 */
public class MyRemoteClient {
    public static void main(String[] args) {
        new MyRemoteClient().go();
    }

    void go() {
        try {
            MyRemote service = (MyRemote) Naming.lookup("rmi://127.0.0.1/Remote Hello");

            String s = service.sayHello();
            System.out.println(s);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
