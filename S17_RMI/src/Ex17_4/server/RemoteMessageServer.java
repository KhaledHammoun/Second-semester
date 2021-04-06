package Ex17_4.server;

import Ex17_4.shared.RemoteMessageList;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

public class RemoteMessageServer implements RemoteMessageList
{
    private List<String> messages;

    public RemoteMessageServer() throws RemoteException
    {
        UnicastRemoteObject.exportObject(this, 0);
        messages = new ArrayList<>();
    }

    @Override
    public synchronized void addMessage(String message) throws RemoteException
    {
        messages.add(message + "\n");
    }

    @Override
    public synchronized void printListSize()
    {
        System.out.println(messages.size());
    }
}
