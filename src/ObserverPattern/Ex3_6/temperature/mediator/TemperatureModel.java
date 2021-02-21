package ObserverPattern.Ex3_6.temperature.mediator;

import ObserverPattern.Ex3_6.temperature.model.Temperature;

public interface TemperatureModel extends NamedPropertyChangeSubject
{
  void addTemperature(String id, double temperature);

  Temperature getLastInsertedTemperature();

  Temperature getLastInsertedTemperature(String id);
}
