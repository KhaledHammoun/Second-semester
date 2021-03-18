package server.network;

import server.model.ChatModel;
import shared.Message;
import shared.User;

import java.util.ArrayList;
import java.util.List;

public class Pool
{
  private List<ServerSocketHandler> connections;
  private ChatModel chatModel;

  public Pool(ChatModel chatModel)
  {
    this.chatModel = chatModel;
    connections = new ArrayList<>();
  }

  public void addConnection(ServerSocketHandler connection)
  {
    connections.add(connection);
  }

  public void broadcastMessage(Message message)
  {
    for (ServerSocketHandler connection : connections)
    {
      chatModel.getFriends(message.getUser());
      connection.sendMessage(message);
    }
  }
}
