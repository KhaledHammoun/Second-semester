package Ex17_2.server;

import Ex17_2.shared.RemoteEchoServer;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class RemoteEchoServerImpl implements RemoteEchoServer
{
    public RemoteEchoServerImpl() throws RemoteException
    {
        UnicastRemoteObject.exportObject(this, 0);
    }

    @Override
    public String toUpperCase(String msg) throws RemoteException
    {
        return msg.toUpperCase();
    }
}
