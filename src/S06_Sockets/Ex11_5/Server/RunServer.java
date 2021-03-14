package S06_Sockets.Ex11_5.Server;

import java.net.Socket;

public class RunServer
{
  public static void main(String[] args)
  {
    SocketServer server = new SocketServer();
    server.startServer();
  }
}
