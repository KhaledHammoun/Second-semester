package client.core;

import client.network.Client;
import client.network.ClientRMI;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ClientFactory
{
  private Client client;
  private static ClientFactory clientFactory;
  private static Lock lock = new ReentrantLock();

  private ClientFactory()
  {
    client = new ClientRMI();
    client.startClient();
  }

  public static ClientFactory getClientFactory()
  {
    if (clientFactory == null)
    {
      synchronized (lock)
      {
        if (clientFactory == null)
        {
          clientFactory = new ClientFactory();
        }
      }
    }
    return clientFactory;
  }

  public Client getClient()
  {
    return client;
  }
}
