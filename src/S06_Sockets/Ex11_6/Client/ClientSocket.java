package S06_Sockets.Ex11_6.Client;

import java.io.IOException;
import java.net.Socket;

public class ClientSocket
{
  public void start() throws IOException
  {
    Socket socket = new Socket("127.0.0.1", 7777);
    ClientSocketHandler clientSocketHandler = new ClientSocketHandler(socket, this);

    Thread clientThread = new Thread(clientSocketHandler);
    clientThread.start();
  }

  public void printMessage()
  {
    System.out.println("Incrementing");
  }
}

