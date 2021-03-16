package Ex12_3.server.mediator;

import S07_MVVM_Sockets.Ex12_3.shared.Temperature;
import S07_MVVM_Sockets.Ex12_3.shared.util.PropertyChangeSubject;

public interface HeaterModel extends PropertyChangeSubject
{
  void addTemperature(Temperature temperature);
  void turnPowerUp();
  void turnPowerDown();
  void setMinMaxTemperature(double minTemperature, double maxTemperature);
}
