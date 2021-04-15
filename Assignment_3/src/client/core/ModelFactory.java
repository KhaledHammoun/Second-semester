package client.core;

import client.model.ChatModel;
import client.model.ChatModelManager;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ModelFactory
{
  private ClientFactory clientFactory;
  private ChatModel chatModel;
  private static ModelFactory modelFactory;
  private static Lock lock = new ReentrantLock();

  private ModelFactory(ClientFactory clientFactory)
  {
    this.clientFactory = ClientFactory.getClientFactory();
    chatModel = new ChatModelManager(clientFactory.getClient());
  }

  public static ModelFactory getModelFactory()
  {
    if (modelFactory == null)
      synchronized (lock)
      {
        if (modelFactory == null)
        {
          modelFactory = new ModelFactory(ClientFactory.getClientFactory());
        }
      }
    return modelFactory;
  }

  public ChatModel getChatModel()
  {
    return chatModel;
  }
}
