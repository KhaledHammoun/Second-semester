package server;

import server.network.SocketServer;

import java.net.ServerSocket;

public class RunServer
{
  public static void main(String[] args)
  {
    SocketServer server = new SocketServer();
    server.startServer();
  }
}
