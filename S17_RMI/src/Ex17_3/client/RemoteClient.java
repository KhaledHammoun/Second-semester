package Ex17_3.client;

import Ex17_3.server.StringChangingServer;
import Ex17_3.shared.IStringChangingServer;
import Ex17_3.shared.IToRandomCase;
import Ex17_3.shared.IToUpperCase;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class RemoteClient
{
    private IToUpperCase toUpperCase;
    private IToRandomCase toRandomCase;

    public void startClient() throws RemoteException, NotBoundException
    {
        Registry registry = LocateRegistry.getRegistry("127.0.0.1", 1099);
        IStringChangingServer server = (IStringChangingServer) registry.lookup("Server");
        toUpperCase = server.getUpperCase();
        toRandomCase = server.getRandomCase();
    }

    public void changeToUpperCase(String message)
    {
        try
        {
            System.out.println(toUpperCase.toUpperCase(message));
        }
        catch (RemoteException e)
        {
            throw new RuntimeException("Could not perform the operation");
        }
    }

    public void changeToRandomCase(String message)
    {
        try
        {
            System.out.println(toRandomCase.toRandomCase(message));
        }
        catch (RemoteException e)
        {
            throw new RuntimeException("Could not perform the operation");
        }
    }
}
