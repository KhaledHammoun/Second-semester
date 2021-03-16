package client.model;

import client.network.Client;

public class ChatModelManager implements ChatModel
{
  private Client client;

  public ChatModelManager(Client client)
  {
    this.client = client;
  }
}
