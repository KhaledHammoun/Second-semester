package server.network;

import server.model.ChatModel;
import server.model.ChatModelManager;
import shared.Message;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServer
{
  private Pool connectionsPool;
  private ChatModel chatModel;

  public SocketServer()
  {
    chatModel = new ChatModelManager();
    this.connectionsPool = new Pool(chatModel);
  }

  public void startServer()
  {
    try(ServerSocket serverSocket = new ServerSocket(9596))
    {
      System.out.println("Server running");
      while (true)
      {
        Socket socket = serverSocket.accept();
        ServerSocketHandler serverSocketHandler = new ServerSocketHandler(socket, chatModel, connectionsPool);
        connectionsPool.addConnection(serverSocketHandler);
        // TODO: 17-03-2021 I am adding too many connections to the pool. They are not al listening to the messages. Try to fix.
        new Thread(serverSocketHandler).start();
      }
    }
    catch (IOException e)
    {
      System.out.println("Server initiation error!");
    }
  }
}
