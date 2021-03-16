package server.network;

import shared.Message;
import shared.User;

import java.util.ArrayList;
import java.util.List;

public class Pool
{
  private List<ServerSocketHandler> connections;
  public Pool()
  {
    connections = new ArrayList<>();
  }

  public void addConnection(ServerSocketHandler connection)
  {
    connections.add(connection);
  }

  public void broadcastMessage(List<User> friends, Message message)
  {
    for (User friend : friends)
    {

    }
  }
}
