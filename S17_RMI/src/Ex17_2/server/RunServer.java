package Ex17_2.server;

import Ex17_2.shared.RemoteEchoServer;

import javax.sound.midi.Soundbank;
import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class RunServer
{
    public static void main(String[] args) throws AlreadyBoundException, RemoteException
    {
        RemoteEchoServer server = new RemoteEchoServerImpl();
        Registry registry = LocateRegistry.createRegistry(1099);
        registry.bind("Server", server);
        System.out.println("Server running");
    }
}
