package edu.examplesForRMIMiniServices;

import java.rmi.*;

/**
 * Simple Remote RMI interface
 * Describe 2 methods
 * which must have remote service
 *
 * Created by sserdiuk on 6/30/17.
 */
public interface ServiceServer extends Remote {
    Object[] getServiceList() throws RemoteException;
    Service getService(Object serviceKey) throws RemoteException;
}
