package S07_MVVM_Sockets.Ex12_1_Ex12_2.Server.network;


import S07_MVVM_Sockets.Ex12_1_Ex12_2.Server.model.DataModel;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServer
{
  private DataModel model;

  public SocketServer(DataModel model)
  {
    this.model = model;
  }

  public void start()
  {
    try (ServerSocket socketServer = new ServerSocket(12345))
    {
      System.out.println("Server running");
      while (true)
      {
        Socket socket = socketServer.accept();
        ServerSocketHandler serverSocketHandler = new ServerSocketHandler(socket, model);
        System.out.println("Connected " + socket.getInetAddress().getHostAddress() + " " + socket.getPort());
        new Thread(serverSocketHandler).start();
      }
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
  }
}
