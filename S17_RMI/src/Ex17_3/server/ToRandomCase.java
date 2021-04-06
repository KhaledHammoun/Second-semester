package Ex17_3.server;

import Ex17_3.shared.IToRandomCase;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Locale;

public class ToRandomCase implements IToRandomCase
{
    public ToRandomCase() throws RemoteException
    {
        UnicastRemoteObject.exportObject(this, 0);
    }

    @Override
    public String toRandomCase(String arg) throws RemoteException
    {
        return arg.toLowerCase();
    }
}
