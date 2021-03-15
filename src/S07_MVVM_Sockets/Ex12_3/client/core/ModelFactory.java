package S07_MVVM_Sockets.Ex12_3.client.core;

import S07_MVVM_Sockets.Ex12_3.client.mediator.HeaterModel;
import S07_MVVM_Sockets.Ex12_3.client.mediator.HeaterModelManager;

public class ModelFactory
{
  private HeaterModel heaterModel;

  public HeaterModel getHeaterModel()
  {
    if (heaterModel == null)
    {
      heaterModel = new HeaterModelManager();
    }
    return heaterModel;
  }
}
