package Ex17_1.client;

import Ex17_1.shared.TextServer;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class TextClient
{
    private TextServer server;

    public void startClient() throws RemoteException, NotBoundException
    {
        Registry registry = LocateRegistry.getRegistry("127.0.0.1", 1099);
        server = (TextServer) registry.lookup("Server");
    }

    public void sendText(String text)
    {
        try
        {
            server.printText(text);
        }
        catch (RemoteException e)
        {
            throw new RuntimeException("Failed sending the message");
        }
    }
}
