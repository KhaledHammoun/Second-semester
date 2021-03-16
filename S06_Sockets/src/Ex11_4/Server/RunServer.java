package Ex11_4.Server;

import java.io.IOException;

public class RunServer
{
  public static void main(String[] args) throws IOException
  {
    Server server = new Server();
    server.start();
  }
}
