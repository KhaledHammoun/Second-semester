package Ex12_1_Ex12_2.Client.core;


import Ex12_1_Ex12_2.Client.network.ClientInterface;
import Ex12_1_Ex12_2.Client.network.SocketClient;

import java.io.IOException;

public class ClientFactory
{
  private ClientInterface client;

  public ClientInterface getClient() throws IOException
  {
    if (client == null)
    {
      client = new SocketClient();
    }
    return client;
  }
}
