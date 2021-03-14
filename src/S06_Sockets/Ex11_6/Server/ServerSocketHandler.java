package S06_Sockets.Ex11_6.Server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ServerSocketHandler implements Runnable
{
  private Socket socket;
  private ObjectInputStream inFromClient;
  private Counter counter;
  private SocketServer socketServer;

  public ServerSocketHandler(Socket socket, Counter counter,
      SocketServer socketServer) throws IOException
  {
    this.socket = socket;
    inFromClient = new ObjectInputStream(socket.getInputStream());
    this.counter = counter;
    this.socketServer = socketServer;
  }

  @Override public void run()
  {
    System.out.println(
        "Connected " + socket.getInetAddress().getHostAddress() + " " + socket
            .getPort());
    for (int i = 0; i < 1000000; i++)
    {
      try
      {
        int message = (int) inFromClient.readUnshared();
        counter.increment();

      }
      catch (IOException | ClassNotFoundException e)
      {

      }
    }
    socketServer.printResult();

  }
}
