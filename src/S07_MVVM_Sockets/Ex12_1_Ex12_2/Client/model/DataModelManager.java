package S07_MVVM_Sockets.Ex12_1_Ex12_2.Client.model;

import S07_MVVM_Sockets.Ex12_1_Ex12_2.Client.network.ClientInterface;
import S07_MVVM_Sockets.Ex12_1_Ex12_2.shared.util.PropertyChangeSubject;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.Date;

public class DataModelManager implements DataModel, PropertyChangeSubject
{
    private PropertyChangeSupport propertyChangeSupport;
    private ClientInterface client;

    public DataModelManager(ClientInterface client) {
        this.client = client;
        client.startClient();
        propertyChangeSupport = new PropertyChangeSupport(this);
        client.addPropertyChangeListener("UpdateTimeStamp", this::updateTimeStamp);
    }

    private void updateTimeStamp(PropertyChangeEvent event)
    {
        propertyChangeSupport.firePropertyChange(event);
    }

    @Override
    public String getLastUpdateTimeStamp() {
      return client.getLastUpdatedTimeStamp();
    }

    @Override
    public int getNumberOfUpdates() {
        return client.getNumberOfUpdates();
    }

    @Override
    public void setTimeStamp(Date timeStamp) {
        client.setTimeStamp(timeStamp);
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
