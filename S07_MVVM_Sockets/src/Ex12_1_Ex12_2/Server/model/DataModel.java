package Ex12_1_Ex12_2.Server.model;



import Ex12_1_Ex12_2.shared.util.PropertyChangeSubject;

import java.util.Date;

public interface DataModel extends PropertyChangeSubject
{
    String getLastUpdateTimeStamp();
    int getNumberOfUpdates();
    void setTimeStamp(Date timeStamp);
}
