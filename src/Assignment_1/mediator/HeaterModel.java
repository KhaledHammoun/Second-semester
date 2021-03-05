package Assignment_1.mediator;

import Assignment_1.model.Temperature;
import Assignment_1.util.PropertyChangeSubject;

public interface HeaterModel extends PropertyChangeSubject
{
  void addTemperature(Temperature temperature);
  void turnPowerUp();
  void turnPowerDown();
  void setMinMaxTemperature(double minTemperature, double maxTemperature);
}
