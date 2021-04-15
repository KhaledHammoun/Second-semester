package Ex17_4.server;

import Ex17_4.shared.RemoteMessageList;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class RunServer
{
    public static void main(String[] args) throws AlreadyBoundException, RemoteException
    {
        RemoteMessageList server = new RemoteMessageServer();
        Registry registry = LocateRegistry.createRegistry(1099);
        registry.bind("Server", server);
        System.out.println("Server running");
    }
}
