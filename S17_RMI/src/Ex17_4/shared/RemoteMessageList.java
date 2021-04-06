package Ex17_4.shared;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RemoteMessageList extends Remote
{
    void addMessage(String message) throws RemoteException;
    void printListSize() throws RemoteException;
}
