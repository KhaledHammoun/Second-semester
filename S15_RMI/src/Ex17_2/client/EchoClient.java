package Ex17_2.client;

import Ex17_2.shared.RemoteEchoServer;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class EchoClient
{
    private RemoteEchoServer server;

    public void startClient() throws RemoteException, NotBoundException
    {
        Registry registry = LocateRegistry.getRegistry("127.0.0.1", 1099);
        server = (RemoteEchoServer) registry.lookup("Server");
    }

    public void addMessage(String msg)
    {
        try
        {
            System.out.println(server.toUpperCase(msg));
        }
        catch (RemoteException e)
        {
            throw new RuntimeException("Message failed to send");
        }
    }
}
