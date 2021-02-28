package S03_MVVM.Ex4_4.temperature.core;

import S03_MVVM.Ex4_4.temperature.mediator.TemperatureModel;
import S03_MVVM.Ex4_4.temperature.mediator.TemperatureModelManager;

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
