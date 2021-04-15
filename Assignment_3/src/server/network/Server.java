package server.network;

import server.model.ChatModel;
import server.model.ChatModelManager;
import shared.Message;
import shared.RequestType;
import shared.User;
import shared.network.RMIClient;
import shared.network.RMIServer;

import java.beans.PropertyChangeEvent;
import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class Server implements RMIServer
{
    private ChatModel model;

    public Server() throws RemoteException
    {
        UnicastRemoteObject.exportObject(this, 0);
        model = new ChatModelManager();
    }

    public void startServer()
    {
        try
        {
            Registry registry = LocateRegistry.createRegistry(1099);
            registry.bind("Server", this);
            System.out.println("Server running!");
        }
        catch (RemoteException | AlreadyBoundException e)
        {
            e.printStackTrace();
        }
    }

    @Override
    public synchronized void Listen(RMIClient client) throws RemoteException
    {
        model.addPropertyChangeListener(RequestType.NEW_MESSAGE.toString(), (event) -> broadcastMessage(event, client));
        model.addPropertyChangeListener(RequestType.NEW_FRIEND.toString(), (event) -> newFriendAdded(event, client));
        model.addPropertyChangeListener(RequestType.NEW_USER.toString(), (event) -> newUserAdded(event, client));
    }

    private synchronized void newUserAdded(PropertyChangeEvent event, RMIClient client)
    {
        try
        {
            client.update(event);
        }
        catch (RemoteException e)
        {
            e.printStackTrace();
        }
    }

    private synchronized void newFriendAdded(PropertyChangeEvent event, RMIClient client)
    {
        try
        {
            client.update(event);
        }
        catch (RemoteException e)
        {
            e.printStackTrace();
        }
    }

    @Override
    public synchronized void addUser(User user) throws RemoteException
    {
        model.addUser(user);
    }

    @Override
    public synchronized void addFriend(User[] users) throws RemoteException
    {
        model.addFriend(users[0], users[1]);
    }

    @Override
    public synchronized void sendMessage(Message message) throws RemoteException
    {
        model.sendMessage(message);
    }

    @Override
    public synchronized void getNumberOfConnections(RMIClient client) throws RemoteException
    {
        client.numberOfConnections(model.getNumberOfUsers());
    }

    private synchronized void broadcastMessage(PropertyChangeEvent event, RMIClient client)
    {
        Message message = (Message) event.getNewValue();
        try
        {
            client.receiveMessage(message);
        }
        catch (RemoteException e)
        {
            e.printStackTrace();
        }
    }
}
