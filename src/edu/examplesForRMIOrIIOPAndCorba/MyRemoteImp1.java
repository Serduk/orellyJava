package edu.examplesForRMIOrIIOPAndCorba;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * Examples for IMP
 *
 * Service must realise remote interface "MyRemote"
 * which method's will be call your client
 *
 * UnicastRemoteObject -> for executing methods remote service,
 * your object must have some criteria,
 * which make him remote.
 * Easy way for this -> extend UnicastRemoteObject
 * who make all work
 *
 * Created by sserdiuk on 6/26/17.
 */
public class MyRemoteImp1 extends UnicastRemoteObject implements MyRemote {

    /*
    * Create constructor without arguments.
    * and declare exception
    * */
    protected MyRemoteImp1() throws RemoteException {
    }

    @Override
    public String sayHello() throws RemoteException {
        return "Server say Hello";
    }

    public void rebind(String text, String service) {
        String texts = text;
        String services = service;
    }

    public static void main(String[] args) {
    /*
    * Add service in RMI
    */

        try {
            MyRemote service = new MyRemoteImp1();
            Naming.rebind("Remote Hello", service);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
