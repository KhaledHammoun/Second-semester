package S07_MVVM_Sockets.Ex12_1_Ex12_2.Client.network;

import S07_MVVM_Sockets.Ex12_1_Ex12_2.shared.util.PropertyChangeSubject;

import java.util.Date;

public interface ClientInterface extends PropertyChangeSubject
{
  String getLastUpdatedTimeStamp();
  int getNumberOfUpdates();
  void setTimeStamp(Date timeStamp);
  void startClient();
}
