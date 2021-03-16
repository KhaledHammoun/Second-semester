package Ex12_1_Ex12_2.Client.network;



import Ex12_1_Ex12_2.shared.util.PropertyChangeSubject;

import java.util.Date;

public interface ClientInterface extends PropertyChangeSubject
{
  String getLastUpdatedTimeStamp();
  int getNumberOfUpdates();
  void setTimeStamp(Date timeStamp);
  void startClient();
}
