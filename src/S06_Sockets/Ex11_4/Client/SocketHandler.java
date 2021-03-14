package S06_Sockets.Ex11_4.Client;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class SocketHandler implements Runnable
{
  private Socket socket;
  private ObjectOutputStream outToServer;
  private ObjectInputStream inFromServer;
  private Client client;
  private int clientID;

  public SocketHandler(Socket socket, Client client) throws IOException
  {
    this.socket = socket;
    outToServer = new ObjectOutputStream(socket.getOutputStream());
    inFromServer = new ObjectInputStream(socket.getInputStream());
    this.client = client;
    clientID = 0;
  }

  @Override public void run()
  {
    try
    {
      clientID = (int) inFromServer.readUnshared();
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
    catch (ClassNotFoundException e)
    {

    }
    while (true)
    {
      try
      {
      outToServer.writeUnshared("Hello from client " + clientID);
      client.printMessage((String) inFromServer.readUnshared());
      Thread.sleep(2000);
      }
      catch (IOException | ClassNotFoundException | InterruptedException e)
      {

      }
    }
  }
}
