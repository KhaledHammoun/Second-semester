package Ex12_3.core;

import Ex12_3.mediator.HeaterModel;
import Ex12_3.mediator.HeaterModelManager;

public class ModelFactory
{
  private HeaterModel heaterModel;
  private ClientFactory clientFactory;

  public ModelFactory(ClientFactory clientFactory)
  {
    this.clientFactory = clientFactory;
  }

  public HeaterModel getHeaterModel()
  {
    if (heaterModel == null)
    {
      heaterModel = new HeaterModelManager(clientFactory.getClient());
    }
    return heaterModel;
  }
}
