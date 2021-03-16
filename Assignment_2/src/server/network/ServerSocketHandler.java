package server.network;

import server.model.ChatModel;

import java.net.Socket;

public class ServerSocketHandler implements Runnable
{
  private Socket socket;
  private ChatModel chatModel;
  private Pool connections;

  public ServerSocketHandler(Socket socket, ChatModel chatModel, Pool connections)
  {
    this.socket = socket;
    this.chatModel = chatModel;
    this.connections = connections;
  }

  @Override public void run()
  {

  }
}
