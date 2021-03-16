package Ex12_1_Ex12_2.Client.model;

import java.util.Date;

public interface DataModel {

    String getLastUpdateTimeStamp();
    int getNumberOfUpdates();
    void setTimeStamp(Date timeStamp);
}
