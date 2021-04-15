package Ex17_3.shared;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IStringChangingServer extends Remote
{
    IToUpperCase getUpperCase() throws RemoteException;
    IToRandomCase getRandomCase() throws RemoteException;
}
