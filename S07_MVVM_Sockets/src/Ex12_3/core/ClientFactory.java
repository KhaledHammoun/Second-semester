package Ex12_3.core;

import Ex12_3.network.Client;
import Ex12_3.network.ClientSocket;

public class ClientFactory
{
  private Client client;

  public Client getClient()
  {
    if (client == null)
    {
      client = new ClientSocket();
    }
    return client;
  }

}
