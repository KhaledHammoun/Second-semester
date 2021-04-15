package Ex17_1.server;

import Ex17_1.shared.TextServer;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class RMITextServer implements TextServer
{
    public RMITextServer() throws RemoteException
    {
        UnicastRemoteObject.exportObject(this, 0);

    }

    @Override
    public void printText(String text) throws RemoteException
    {
        System.out.println(text);
    }
}
