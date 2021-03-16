package Ex11_4.Client;

import java.io.IOException;
import java.net.Socket;

public class Client
{
  public void start() throws IOException
  {
    Socket socket = new Socket("127.0.0.1", 2345);

    SocketHandler socketHandler = new SocketHandler(socket, this);
    Thread thread = new Thread(socketHandler);
    thread.start();
  }

  public void printMessage(String message)
  {
    System.out.println(message);
  }
}
