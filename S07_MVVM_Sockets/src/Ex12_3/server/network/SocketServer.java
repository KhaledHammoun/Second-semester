package Ex12_3.server.network;

import S07_MVVM_Sockets.Ex12_3.server.mediator.HeaterModel;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServer
{
  private HeaterModel model;

  public SocketServer(HeaterModel model)
  {
    this.model = model;
  }

  public void start()
  {
    try (ServerSocket serverSocket = new ServerSocket(9596))
    {
      Socket socket = serverSocket.accept();
      ServerSocketHandler serverSocketHandler = new ServerSocketHandler(socket, model);

      new Thread(serverSocketHandler).start();
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
  }
}
