package Ex11_4.Server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server
{
  private int clientID = 0;

  public void start() throws IOException
  {
    try (ServerSocket serverSocket = new ServerSocket(2345))
    {
      while (true)
      {
        Socket socket = serverSocket.accept();
        clientID++;
        ServerSocketHandler serverSocketHandler = new ServerSocketHandler(socket, clientID, this);

        Thread thread = new Thread(serverSocketHandler);
        thread.start();
      }
    }
  }
  public void printMessage(String message)
  {
    System.out.println(message);
  }
}
