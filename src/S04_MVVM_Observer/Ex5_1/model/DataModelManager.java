package S04_MVVM_Observer.Ex5_1.model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DataModelManager implements DataModel, PropertyChangeSubject {

    private String lastUpdate;
    private int numberOfUpdates;
    private int recalculateDataCount;
    private PropertyChangeSupport propertyChangeSupport;

    public DataModelManager() {
        propertyChangeSupport = new PropertyChangeSupport(this);
    }

    @Override
    public String getLastUpdateTimeStamp() {
        return lastUpdate;
    }

    @Override
    public void increaseNumberOfUpdates() {
        numberOfUpdates++;
    }

    public void increaseRecalculateDataCount()
    {
        recalculateDataCount++;
        if (recalculateDataCount%10 == 0)
        {
            String toReturn = "Red";
            if (recalculateDataCount%20 == 0)
            {
                toReturn = "Green";
            }
            propertyChangeSupport.firePropertyChange("ColourChange", recalculateDataCount, toReturn);
        }
    }

    public int getRecalculateDataCount()
    {
        return recalculateDataCount;
    }
    @Override
    public int getNumberOfUpdates() {
        return numberOfUpdates;
    }

    public void recalculateData() {
        increaseRecalculateDataCount();
        String last = lastUpdate;
        calcTimeStamp();
        propertyChangeSupport.firePropertyChange("Updated", last, lastUpdate);
    }

    private void calcTimeStamp() {
        SimpleDateFormat sdfDate = new SimpleDateFormat("HH:mm:ss");
        Date now = new Date();
        String strDate = sdfDate.format(now);
        System.out.println(strDate);
        lastUpdate = strDate;
    }

    @Override
    public void addPropertyChangeListener(String name, PropertyChangeListener listener) {
        propertyChangeSupport.addPropertyChangeListener(name, listener);
    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.addPropertyChangeListener(listener);
    }

    @Override
    public void removePropertyChangeListener(String name, PropertyChangeListener listener) {
        propertyChangeSupport.removePropertyChangeListener(name, listener);
    }

    @Override
    public void removePropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.removePropertyChangeListener(listener);
    }
}
