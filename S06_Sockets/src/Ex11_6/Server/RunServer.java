package Ex11_6.Server;

import java.io.IOException;

public class RunServer
{
  public static void main(String[] args)
      throws IOException, InterruptedException
  {
    Counter counter = new Counter();
    SocketServer socketServer = new SocketServer(counter);
    socketServer.startServer();
  }
}
