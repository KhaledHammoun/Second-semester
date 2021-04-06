package Ex17_1.server;

import Ex17_1.shared.TextServer;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class RunServer
{
    public static void main(String[] args) throws RemoteException, AlreadyBoundException
    {
        TextServer server = new RMITextServer();
        Registry registry = LocateRegistry.createRegistry(1099);
        registry.bind("Server", server);
        System.out.println("Server running");
    }
}
