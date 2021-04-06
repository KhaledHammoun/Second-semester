package Ex17_2.shared;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RemoteEchoServer extends Remote
{
    String toUpperCase(String msg) throws RemoteException;
}
