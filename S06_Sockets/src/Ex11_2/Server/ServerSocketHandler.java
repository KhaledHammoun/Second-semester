package Ex11_2.Server;

import Ex11_2.Client.Message;

import java.io.*;
import java.net.Socket;

public class ServerSocketHandler implements Runnable
{
  private Socket socket;

  public ServerSocketHandler(Socket socket)
  {
    this.socket = socket;
  }

  @Override public void run()
  {
    try
    {
      System.out.println(
          "Client connected from " + socket.getInetAddress().getHostAddress()
              + " " + socket.getLocalPort());
      ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
      ObjectInputStream in = new ObjectInputStream(
          socket.getInputStream());

      out.writeUnshared("Hello from server. Write your name");
      Message nameFromClient = (Message) in.readUnshared();

      out.writeUnshared("Hello " + nameFromClient);
      for (int i = 0; i < 3; i++)
      {
        out.writeUnshared("Please give me a String to uppercase.");
        Message toUppercase = (Message) in.readUnshared();
        out.writeUnshared(toUppercase.toUpperCase());
      }
    }
    catch (IOException | ClassNotFoundException e)
    {

    }
  }
}
