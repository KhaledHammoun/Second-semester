package Ex17_3.shared;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IToUpperCase extends Remote
{
    String toUpperCase(String arg) throws RemoteException;
}
