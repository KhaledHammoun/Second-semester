package Ex11_3.Client;

import java.io.IOException;
import java.net.Socket;

public class RunClient
{
  public static void main(String[] args) throws IOException, ClassNotFoundException
  {
    Socket socket = new Socket("127.0.0.1", 1234);
    SocketClient socketClient = new SocketClient(socket);
    socketClient.start();
  }
}
