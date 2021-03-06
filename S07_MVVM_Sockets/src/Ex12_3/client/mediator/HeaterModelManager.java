package Ex12_3.client.mediator;



import Ex12_3.client.network.Client;
import Ex12_3.server.model.OffState;
import Ex12_3.server.model.Radiator;
import Ex12_3.shared.Temperature;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class HeaterModelManager implements HeaterModel
{

  private PropertyChangeSupport support = new PropertyChangeSupport(this);
  private Client client;
  private Temperature maxTemperature;
  private Temperature minTemperature;
  private String warningColourOld;
  private String warningTextOld;
  private Radiator radiator;

  public HeaterModelManager(Client client)
  {
    this.client = client;
  }

  public void checkForWarnings(Temperature temperature)
  {
    String warningTextNew = "";
    String warningColourNew = "#ffffff00";
    if (temperature.getValue() > maxTemperature.getValue())
    {
      warningColourNew = "red";
      warningTextNew = "Warning too Hot!";
    }
    else if (temperature.getValue() < minTemperature.getValue())
    {
      warningColourNew = "blue";
      warningTextNew = "Warning too Cold!";
    }
    support.firePropertyChange("warningColour", warningColourOld, warningColourNew);
    support.firePropertyChange("warningText", warningTextOld, warningTextNew);
    warningColourOld = warningColourNew;
    warningTextOld = warningTextNew;
  }

  @Override public void addTemperature(Temperature temperature)
  {
    support.firePropertyChange(temperature.getId(), "", temperature);
    if (temperature.getId().equals("t1") || temperature.getId().equals("t2"))
    {
      checkForWarnings(temperature);
    }
  }

  @Override public void turnPowerUp()
  {
    radiator.turnUp();
  }

  @Override public void turnPowerDown()
  {
    radiator.turnDown();
  }

  @Override public void setMinMaxTemperature(double minTemperature,
      double maxTemperature)
  {
    this.minTemperature.setValue(minTemperature);
    this.maxTemperature.setValue(maxTemperature);
  }

  @Override public void addPropertyChangeListener(String name,
      PropertyChangeListener listener)
  {
    support.addPropertyChangeListener(name, listener);
  }

  @Override public void addPropertyChangeListener(
      PropertyChangeListener listener)
  {
    support.addPropertyChangeListener(listener);
  }

  @Override public void removePropertyChangeListener(String name,
      PropertyChangeListener listener)
  {
    support.removePropertyChangeListener(name, listener);
  }

  @Override public void removePropertyChangeListener(
      PropertyChangeListener listener)
  {
      support.removePropertyChangeListener(listener);
  }
}
