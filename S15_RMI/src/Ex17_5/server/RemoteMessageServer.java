package Ex17_5.server;

import Ex17_5.shared.RemoteMessageList;
import Ex17_5.shared.ReplyTo;

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
    public synchronized void addMessage(String msg, ReplyTo who) throws RemoteException
    {
        messages.add(msg);
        System.out.println(messages);
        who.replyMessage("Thank you");
    }
}
