package S06_Sockets.Ex11_3.Server;

import S06_Sockets.Ex11_3.transferableobjects.Request;
import S06_Sockets.Ex11_3.transferableobjects.RequestType;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ServerSocketHandler implements Runnable
{
  private Socket socket;
  private ObjectOutputStream outToClient;
  private ObjectInputStream inFromClient;
  private Request request;

  public ServerSocketHandler(Socket socket) throws IOException
  {
    this.socket = socket;
    outToClient = new ObjectOutputStream(socket.getOutputStream());
    inFromClient = new ObjectInputStream(socket.getInputStream());
    request = new Request("", null);
  }

  @Override public void run()
  {
    try
    {
      System.out.println(
          "Client connected from " + socket.getInetAddress().getHostAddress()
              + " " + socket.getLocalPort());

      outToClient.writeUnshared("Hello from server. Write your name");
      String nameFromClient = (String) inFromClient.readUnshared();

      outToClient.writeUnshared("Hello " + nameFromClient + ". Give me the conversion type.");
      request.setRequestType(RequestType.valueOf((String) inFromClient.readUnshared()));

      for (int i = 0; i < 3; i++)
      {
        outToClient.writeUnshared("Please give me a String to "+ request.getRequestType());
        request.setArgument ((String) inFromClient.readUnshared());
        outToClient.writeUnshared(request.update());
      }
    }
    catch (IOException | ClassNotFoundException e)
    {

    }
  }
}
