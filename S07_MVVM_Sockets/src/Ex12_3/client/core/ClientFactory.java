package Ex12_3.client.core;

import Ex12_3.client.network.Client;
import Ex12_3.client.network.ClientSocket;

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
