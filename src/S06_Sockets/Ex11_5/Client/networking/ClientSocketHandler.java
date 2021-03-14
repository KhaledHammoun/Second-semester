package S06_Sockets.Ex11_5.Client.networking;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ClientSocketHandler implements Runnable
{

  private Socket socket;
  private ObjectInputStream inFromServer;
  private ObjectOutputStream outToServer;
  private ClientSocket clientSocket;

  public ClientSocketHandler(Socket socket, ClientSocket clientSocket) throws IOException
  {
    this.socket = socket;
    inFromServer = new ObjectInputStream(socket.getInputStream());
    outToServer = new ObjectOutputStream(socket.getOutputStream());
    this.clientSocket = clientSocket;
  }

  public void sendMessage(String message)
  {
    try
    {
      outToServer.writeUnshared(message);
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
        clientSocket.messageReceived((String) inFromServer.readUnshared());
      }
      catch (IOException | ClassNotFoundException e)
      {

      }
    }
  }
}
