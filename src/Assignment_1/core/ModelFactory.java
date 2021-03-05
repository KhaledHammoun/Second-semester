package Assignment_1.core;

import Assignment_1.mediator.HeaterModel;
import Assignment_1.mediator.HeaterModelManager;

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
