package Ex17_6.client;

import Ex17_6.shared.RemoteTaskList;
import Ex17_6.shared.Task;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class RMITaskClient
{
    private RemoteTaskList server;

    public void startClient() throws RemoteException, NotBoundException
    {
        Registry registry = LocateRegistry.getRegistry("localhost", 1099);
        server = (RemoteTaskList) registry.lookup("Server");
    }

    public void addTask(String text, Long time)
    {
        try
        {
            server.add(new Task(text, time));
        }
        catch (RemoteException e)
        {
            throw new RuntimeException("Could not connect to server.");
        }
    }

    public void remove()
    {
        try
        {
            System.out.println(server.remove());
        }
        catch (RemoteException e)
        {
            throw new RuntimeException("Could not connect to server.");
        }
    }

    public void size()
    {
        try
        {
            System.out.println(server.size());
        }
        catch (RemoteException e)
        {
            throw new RuntimeException("Could not connect to server.");
        }
    }
}
