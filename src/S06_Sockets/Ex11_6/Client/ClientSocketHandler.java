package S06_Sockets.Ex11_6.Client;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ClientSocketHandler implements Runnable
{
  private Socket socket;
  private ObjectOutputStream outToServer;
  private ClientSocket clientSocket;

  public ClientSocketHandler(Socket socket, ClientSocket clientSocket)
      throws IOException
  {
    this.socket = socket;
    outToServer = new ObjectOutputStream(socket.getOutputStream());
    this.clientSocket = clientSocket;
  }

  @Override public void run()
  {
    while (true)
    {
      try
      {
        outToServer.writeUnshared(0);
      }
      catch (IOException e)
      {
        e.printStackTrace();
      }
    }
  }
}