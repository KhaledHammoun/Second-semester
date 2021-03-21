package server.network;

import server.model.ChatModel;
import shared.Message;
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
      connection.sendMessage(message);
    }
  }

  public int getNumberOfConnections()
  {
    return connections.size();
  }
}
