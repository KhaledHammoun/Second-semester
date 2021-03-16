package mediator;

import model.Temperature;
import util.PropertyChangeSubject;

public interface HeaterModel extends PropertyChangeSubject
{
  void addTemperature(Temperature temperature);
  void turnPowerUp();
  void turnPowerDown();
  void setMinMaxTemperature(double minTemperature, double maxTemperature);
}
