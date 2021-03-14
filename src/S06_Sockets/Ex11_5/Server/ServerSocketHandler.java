package S06_Sockets.Ex11_5.Server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.concurrent.CancellationException;

public class ServerSocketHandler implements Runnable
{
  private Socket socket;
  private ObjectOutputStream outToClient;
  private ObjectInputStream inFromClient;
  private Pool connections;

  public ServerSocketHandler(Socket socket, Pool connections) throws IOException
  {
    this.socket = socket;
    this.outToClient = new ObjectOutputStream(socket.getOutputStream());
    this.inFromClient = new ObjectInputStream(socket.getInputStream());
    this.connections = connections;
  }

  public void sendMessage(String message)
  {
    try
    {
      outToClient.writeUnshared(message);
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
  }

  @Override public void run()
  {
    while (true)
    {
      try
      {
        connections.broadcastMessage((String) inFromClient.readUnshared());
      }
      catch (IOException | ClassNotFoundException e)
      {

      }
    }
  }
}
