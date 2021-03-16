package core;

import mediator.HeaterModel;
import mediator.HeaterModelManager;

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
