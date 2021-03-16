package client.core;

import client.model.ChatModel;
import client.model.ChatModelManager;

public class ModelFactory
{
  private ClientFactory clientFactory;
  private ChatModel chatModel;

  public ModelFactory(ClientFactory clientFactory)
  {
    this.clientFactory = clientFactory;
  }

  public ChatModel getChatModel()
  {
    if (chatModel == null)
    {
      chatModel = new ChatModelManager(clientFactory.getClient());
    }
    return chatModel;
  }
}
