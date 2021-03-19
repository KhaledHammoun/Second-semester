package server;

import server.network.SocketServer;

public class RunServer
{
  public static void main(String[] args)
  {
    SocketServer server = new SocketServer();
    server.startServer();
  }
}
