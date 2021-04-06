package Ex17_4.client;

import Ex17_4.shared.RemoteMessageList;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class RemoteMessageClient
{
    private RemoteMessageList server;

    public void startClient() throws RemoteException, NotBoundException
    {
        Registry registry = LocateRegistry.getRegistry(1099);
        server = (RemoteMessageList) registry.lookup("Server");
    }

    public void addMessage(String message)
    {
        try
        {
            server.addMessage(message);
        }
        catch (RemoteException e)
        {
            throw new RuntimeException("Unable to connect to the server");
        }
    }

    public void printMessagesSize()
    {
        try
        {
            server.printListSize();
        }
        catch (RemoteException e)
        {
            throw new RuntimeException("Could not get the number of messages");
        }
    }
}
