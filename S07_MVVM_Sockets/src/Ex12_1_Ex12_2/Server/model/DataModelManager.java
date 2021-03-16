package S07_MVVM_Sockets.Ex12_1_Ex12_2.Server.model;



import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DataModelManager implements DataModel
{
    private PropertyChangeSupport propertyChangeSupport;
    private String lastUpdate;
    private int numberOfUpdates;

    public DataModelManager() {
        propertyChangeSupport = new PropertyChangeSupport(this);
    }

    @Override
    public String getLastUpdateTimeStamp() {
      return lastUpdate;
    }

    @Override
    public int getNumberOfUpdates() {
        return numberOfUpdates;
    }

    @Override
    public void setTimeStamp(Date timeStamp) {
        SimpleDateFormat sdfDate = new SimpleDateFormat("HH:mm:ss");
        String strDate = sdfDate.format(timeStamp);
        System.out.println(strDate);
        String last = lastUpdate;
        lastUpdate = strDate;
        numberOfUpdates++;
        propertyChangeSupport.firePropertyChange("UpdateTimeStamp", last, lastUpdate);
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
