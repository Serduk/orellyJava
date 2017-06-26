package edu.examplesForRMIOrIIOPAndCorba;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Example for RMI Technology
 * Created by sserdiuk on 6/26/17.
 */
public interface MyRemote extends Remote {
    public String sayHello() throws RemoteException;
}
