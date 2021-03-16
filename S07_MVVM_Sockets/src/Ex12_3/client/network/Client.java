package Ex12_3.client.network;

import Ex12_3.shared.Temperature;
import Ex12_3.shared.util.PropertyChangeSubject;

public interface Client extends PropertyChangeSubject
{
  void addTemperature(Temperature temperature);
  void turnPowerUp();
  void turnPowerDown();
  void setMinMaxTemperature(double minTemperature, double maxTemperature);
  void startClient();
}
