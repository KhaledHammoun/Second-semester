package MVVM.Ex4_4.temperature.mediator;

import MVVM.Ex4_4.temperature.model.Temperature;

public interface TemperatureModel
{
  void addTemperature(String id, double temperature);

  Temperature getLastInsertedTemperature();

  Temperature getLastInsertedTemperature(String id);
}
