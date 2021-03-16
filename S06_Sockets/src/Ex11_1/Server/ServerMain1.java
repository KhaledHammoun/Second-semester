package Ex11_1.Server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerMain1
{

  public static void main(String[] args) throws IOException
  {
    ServerSocket serverSocket = new ServerSocket(1235);
    while (true)
    {
      Socket socket = serverSocket.accept();

      Thread thread = new Thread(new ServerSocketHandler(socket));
      thread.start();
    }
  }
}
