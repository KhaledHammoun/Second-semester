package Ex17_3.server;

import Ex17_3.shared.IStringChangingServer;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class RunServer
{
    public static void main(String[] args) throws AlreadyBoundException, RemoteException
    {
        IStringChangingServer server = new StringChangingServer();
        Registry registry = LocateRegistry.createRegistry(1099);
        registry.bind("Server", server);
        System.out.println("Server running");
    }
}
