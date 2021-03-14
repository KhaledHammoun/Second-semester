package S06_Sockets.Ex11_4.Server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ServerSocketHandler implements Runnable
{
  private Socket socket;
  private ObjectInputStream inFromClient;
  private ObjectOutputStream outToClient;
  private int clientID;
  private Server server;

  public ServerSocketHandler(Socket socket, int clientID, Server server)
      throws IOException
  {
    this.socket = socket;
    outToClient = new ObjectOutputStream(socket.getOutputStream());
    inFromClient = new ObjectInputStream(socket.getInputStream());
    this.clientID = clientID;
    this.server = server;
  }

  @Override public void run()
  {
    System.out.println(
        "Connected " + socket.getInetAddress().getHostAddress() + " " + socket
            .getPort());
    try
    {
      outToClient.writeUnshared(clientID);
    }
    catch (IOException e)
    {

    }
    while (true)
    {
      try
      {
        server.printMessage((String) inFromClient.readUnshared());
        outToClient
            .writeUnshared("And hello to you, client number " + clientID);
      }
      catch (IOException | ClassNotFoundException e)
      {

      }
    }

  }
}
