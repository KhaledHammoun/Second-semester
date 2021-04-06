package Ex17_6.server;

import Ex17_6.shared.RemoteTaskList;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class RunServer
{
    public static void main(String[] args) throws AlreadyBoundException, RemoteException
    {
        RemoteTaskList server = new RMITaskServer();
        Registry registry = LocateRegistry.createRegistry(1099);
        registry.bind("Server" ,server);
        System.out.println("Server running");
    }
}
