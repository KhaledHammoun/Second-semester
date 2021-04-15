package server;

import server.network.Server;

import java.rmi.RemoteException;

public class RunServer
{
  public static void main(String[] args) throws RemoteException
  {
    Server server = new Server();
    server.startServer();
  }
}
