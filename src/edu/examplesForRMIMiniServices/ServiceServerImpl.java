package edu.examplesForRMIMiniServices;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;

/**
 * Remote Realisation example
 *
 * Created by sserdiuk on 6/30/17.
 */
public class ServiceServerImpl extends UnicastRemoteObject implements ServiceServer {
    /*
    * All services will be saved in HashMap;
    * Instead one object we add in collection -> two;
    * Key (usually -> String) and Value (usually -> Object)
    * */
    HashMap serviceList;


    protected ServiceServerImpl() throws RemoteException {
        setUpServices();
    }

    /*
    * When constructor is calling
    * we initialize universal services (DeviceService, MiniMusicService and etc);
    *
    * Create Services and put it all in to hashMap
    * */
    void setUpServices() {
        serviceList = new HashMap();
        serviceList.put("Dice Rolling Service", new DiceService());
        serviceList.put("Day Of The Week Service", new DayOfTheWeekService());
        serviceList.put("Visual Musi Service", new MiniMusicService());
    }

    /*
    * Client Call this method,
    * for get list all services,
    * And show it in browser (User mast choose one of them)
    * We Send Array with type Object (but inside he has Strings),
    * which consist only from keys,
    * who saved inside in HashMap.
    * We don't be send service,
    * while client don't ask us about i (Call method getService())
    * */
    @Override
    public Object[] getServiceList() throws RemoteException {
        System.out.println("In Remote");
        return serviceList.keySet().toArray();
    }


    /*
    * Client Call this method after user choose service in collapse service
    * (List of all service from method getServiceList();)
    *
    * */
    @Override
    public Service getService(Object serviceKey) throws RemoteException {
        Service theService = (Service) serviceList.get(serviceKey);
        return theService;
    }

    public static void main(String[] args) {
        try {
            Naming.rebind("ServiceServer", new ServiceServerImpl());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        System.out.println("Remote Service Is Running");
    }
}
