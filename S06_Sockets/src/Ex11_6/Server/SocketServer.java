package Ex11_6.Server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServer
{
  private Counter counter;

  public SocketServer(Counter counter)
  {
    this.counter = counter;
  }

  public void startServer() throws IOException
  {
    ServerSocket serverSocket = new ServerSocket(7777);
      while (true)
      {
        Socket socket = serverSocket.accept();
        ServerSocketHandler serverSocketHandler = new ServerSocketHandler(socket, counter, this);

        Thread connection = new Thread(serverSocketHandler);
        connection.start();
      }
  }

  public synchronized void printResult()
  {
    System.out.println(counter.getCounter());
  }
}
