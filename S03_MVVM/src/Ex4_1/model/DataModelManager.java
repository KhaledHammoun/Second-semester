package Ex4_1.model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DataModelManager implements DataModel {

    private String lastUpdate;
    private int numberOfUpdates = 0;

    public DataModelManager() {
        System.out.println("Ny DataModel");
    }

    @Override
    public String getLastUpdateTimeStamp() {
        return lastUpdate;
    }

    @Override public void increase()
    {
        numberOfUpdates++;
    }

    @Override public int getNumberOfUpdates()
    {
        return numberOfUpdates;
    }

    public void recalculateData() {
        calcTimeStamp();
    }

    private void calcTimeStamp() {
        SimpleDateFormat sdfDate = new SimpleDateFormat("HH:mm:ss");
        Date now = new Date();
        String strDate = sdfDate.format(now);
        System.out.println(strDate);
        lastUpdate = strDate;
    }
}
