package S02_ObserverPattern.Ex3_6.temperature.mediator;

import S02_ObserverPattern.Ex3_6.temperature.model.Temperature;

public interface TemperatureModel extends NamedPropertyChangeSubject
{
  void addTemperature(String id, double temperature);

  Temperature getLastInsertedTemperature();

  Temperature getLastInsertedTemperature(String id);
}