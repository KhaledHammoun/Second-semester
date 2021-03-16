
package Ex11_5.Server;

import java.util.ArrayList;
import java.util.List;

public class Pool
{
  private List<ServerSocketHandler> connections;

  public Pool()
  {
    connections = new ArrayList<>();
  }

  public synchronized void addConnection(ServerSocketHandler connection)
  {
    connections.add(connection);
  }

  public synchronized void broadcastMessage(String message)
  {
    for (ServerSocketHandler conn : connections)
    {
      conn.sendMessage(message);
    }
  }
}
