package Ex17_5.client;

import Ex17_5.shared.RemoteMessageList;
import Ex17_5.shared.ReplyTo;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class RemoteMessageClient implements ReplyTo
{
    private RemoteMessageList server;

    public RemoteMessageClient() throws RemoteException
    {
        UnicastRemoteObject.exportObject(this, 0);
    }

    public void startClient() throws RemoteException, NotBoundException
    {
        Registry registry = LocateRegistry.getRegistry("localhost", 1099);
        server = (RemoteMessageList) registry.lookup("Server");

    }

    public void addMessage(String msg)
    {
        try
        {
            server.addMessage(msg, this);
        }
        catch (RemoteException e)
        {
            throw new RuntimeException("Could not connect to server.");
        }
    }

    @Override
    public void replyMessage(String msg)
    {
        System.out.println(msg);
    }
}
