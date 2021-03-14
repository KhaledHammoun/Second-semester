package S06_Sockets.Ex11_2.Client;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client
{
  private Socket socket;
  private ObjectOutputStream outToServer;
  private ObjectInputStream inFromServer;

  public Client(Socket socket) throws IOException
  {
    this.socket = socket;
    outToServer = new ObjectOutputStream(socket.getOutputStream());
    inFromServer = new ObjectInputStream(socket.getInputStream());
  }

  public void start() throws IOException, ClassNotFoundException
  {
    Message message = (Message) inFromServer.readUnshared();
    System.out.println(message);
    String name = new Scanner(System.in).nextLine();
    outToServer.writeUnshared(name);
    message = (Message) inFromServer.readUnshared();
    System.out.println(message);
    for (int i = 0; i < 3; i++)
    {
      message = (Message) inFromServer.readUnshared();
      System.out.println(message);
      String ward = new Scanner(System.in).nextLine();
      outToServer.writeUnshared(ward);
      message = (Message) inFromServer.readUnshared();
      System.out.println(message);
    }
  }
}
