package shared.network;

import shared.Message;
import shared.User;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RMIServer extends Remote
{
    void Listen(RMIClient client) throws RemoteException;
    void addUser(User user) throws RemoteException;
    void addFriend(User[] users) throws RemoteException;
    void sendMessage(Message message) throws RemoteException;
    void getNumberOfConnections(RMIClient client) throws RemoteException;
}
