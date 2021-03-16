package Ex11_3.Server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class RunServer
{
  public static void main(String[] args) throws IOException
  {
    ServerSocket serverSocket = new ServerSocket(1234);
    while (true)
    {
      Socket socket = serverSocket.accept();
      ServerSocketHandler serverSocketHandler = new ServerSocketHandler(socket);
      Thread thread = new Thread(serverSocketHandler);
      thread.start();
    }
  }
}
