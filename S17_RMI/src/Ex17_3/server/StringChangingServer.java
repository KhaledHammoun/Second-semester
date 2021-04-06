package Ex17_3.server;

import Ex17_3.shared.IStringChangingServer;
import Ex17_3.shared.IToRandomCase;
import Ex17_3.shared.IToUpperCase;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class StringChangingServer implements IStringChangingServer
{

    public StringChangingServer() throws RemoteException
    {
        UnicastRemoteObject.exportObject(this, 0);
    }

    @Override
    public IToUpperCase getUpperCase() throws RemoteException
    {
        return new ToUpperCase();
    }

    @Override
    public IToRandomCase getRandomCase() throws RemoteException
    {
        return new ToRandomCase();
    }
}
