package Ex12_3.client.mediator;

import Ex12_3.shared.Temperature;
import Ex12_3.shared.util.PropertyChangeSubject;

public interface HeaterModel extends PropertyChangeSubject
{
  void addTemperature(Temperature temperature);
  void turnPowerUp();
  void turnPowerDown();
  void setMinMaxTemperature(double minTemperature, double maxTemperature);
}
