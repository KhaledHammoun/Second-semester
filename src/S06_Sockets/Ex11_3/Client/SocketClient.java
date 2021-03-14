package S06_Sockets.Ex11_3.Client;

import S06_Sockets.Ex11_3.transferableobjects.Request;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class SocketClient
{
  private Socket socket;
  private ObjectOutputStream outToServer;
  private ObjectInputStream inFromServer;
  private Scanner scanner;

  public SocketClient(Socket socket) throws IOException
  {
    this.socket = socket;
    outToServer = new ObjectOutputStream(socket.getOutputStream());
    inFromServer = new ObjectInputStream(socket.getInputStream());
    scanner = new Scanner(System.in);
  }

  public void start() throws ClassNotFoundException, IOException
  {
    System.out.println(inFromServer.readUnshared());
    outToServer.writeUnshared(scanner.nextLine());
    System.out.println(inFromServer.readUnshared());
    outToServer.writeUnshared(scanner.nextLine());

    for (int i = 0; i < 3; i++)
    {
      System.out.println(inFromServer.readUnshared());
      outToServer.writeUnshared(scanner.nextLine());
      System.out.println(inFromServer.readUnshared());
    }
  }
}
