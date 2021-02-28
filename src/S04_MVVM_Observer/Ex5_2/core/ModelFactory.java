package S04_MVVM_Observer.Ex5_2.core;

import S04_MVVM_Observer.Ex5_2.mediator.TemperatureModel;
import S04_MVVM_Observer.Ex5_2.mediator.TemperatureModelManager;

public class ModelFactory
{
  private TemperatureModel temperatureModel;

  public TemperatureModel getTemperatureModel()
  {
    if (temperatureModel == null)
    {
      temperatureModel = new TemperatureModelManager();
    }
    return temperatureModel;
  }
}
