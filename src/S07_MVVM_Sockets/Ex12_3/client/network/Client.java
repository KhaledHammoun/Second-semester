package S07_MVVM_Sockets.Ex12_3.client.network;

import S07_MVVM_Sockets.Ex12_3.shared.external.Temperature;
import S07_MVVM_Sockets.Ex12_3.shared.util.PropertyChangeSubject;

public interface Client extends PropertyChangeSubject
{
  void addTemperature(Temperature temperature);
  void turnPowerUp();
  void turnPowerDown();
  void setMinMaxTemperature(double minTemperature, double maxTemperature);
  void startClient();
}
