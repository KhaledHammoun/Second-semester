package S04_MVVM_Observer.Ex5_2.mediator;

import S04_MVVM_Observer.Ex5_2.model.Temperature;

public interface TemperatureModel extends PropertyChangeSubject
{
  void addTemperature(String id, double temperature);

  Temperature getLastInsertedTemperature();

  Temperature getLastInsertedTemperature(String id);
}
