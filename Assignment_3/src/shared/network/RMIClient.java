package shared.network;

import shared.Message;

import java.beans.PropertyChangeEvent;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RMIClient extends Remote
{
    void update(PropertyChangeEvent event) throws RemoteException;
    void numberOfConnections(int connections) throws RemoteException;
    void receiveMessage(Message message) throws RemoteException;
}
