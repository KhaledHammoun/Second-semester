package client.network;

import shared.Message;
import shared.RequestType;
import shared.User;
import shared.network.RMIClient;
import shared.network.RMIServer;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class ClientRMI implements Client, RMIClient
{
    private RMIServer server;
    private PropertyChangeSupport support = new PropertyChangeSupport(this);


    public ClientRMI()
    {
        try
        {
            UnicastRemoteObject.exportObject(this, 0);
        }
        catch (RemoteException e)
        {
            e.printStackTrace();
            System.out.println("Could not initialize the client!");
        }
    }

    @Override
    public void startClient()
    {
        try
        {
            Registry registry = LocateRegistry.getRegistry(1099);
            server = (RMIServer) registry.lookup("Server");
            server.Listen(this);
        }
        catch (RemoteException | NotBoundException e)
        {
            e.printStackTrace();
            System.out.println("Server not found!");
        }
    }

    @Override
    public void addUser(User user)
    {
        try
        {
            server.addUser(user);
        }
        catch (RemoteException e)
        {
            throw new RuntimeException("Could not add a new user!");
        }
    }

    @Override
    public void addFriend(User user, User friend)
    {
        User[] users = {user, friend};
        try
        {
            server.addFriend(users);
        }
        catch (RemoteException e)
        {
            throw new RuntimeException("Could not add a new friend!");

        }
    }

    @Override
    public void sendMessage(Message message)
    {
        try
        {
            server.sendMessage(message);
        }
        catch (RemoteException e)
        {
            throw new RuntimeException("Could not send the message!");

        }
    }

    @Override
    public void receiveMessage(Message message)
    {
        support.firePropertyChange(RequestType.NEW_MESSAGE.toString(), null, message);
    }

    @Override
    public void getNumberOfConnections()
    {
        try
        {
            server.getNumberOfConnections(this);
        }
        catch (RemoteException e)
        {
            throw new RuntimeException("Could not get number of connections!");

        }
    }

    @Override
    public void update(PropertyChangeEvent event)
    {
        support.firePropertyChange(event);

    }

    @Override
    public void numberOfConnections(int connections)
    {
        support.firePropertyChange(RequestType.GET_CONNECTIONS.toString(), null, connections);
    }

    @Override
    public void addPropertyChangeListener(String name, PropertyChangeListener listener)
    {
        support.addPropertyChangeListener(name, listener);
    }

    @Override
    public void removePropertyChangeListener(String name, PropertyChangeListener listener)
    {
        support.removePropertyChangeListener(name, listener);
    }
}
