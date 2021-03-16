package S07_MVVM_Sockets.Ex12_1_Ex12_2.Server.model;

import S07_MVVM_Sockets.Ex12_1_Ex12_2.shared.util.PropertyChangeSubject;

import java.util.Date;

public interface DataModel extends PropertyChangeSubject
{

    String getLastUpdateTimeStamp();
    int getNumberOfUpdates();
    void setTimeStamp(Date timeStamp);
}
