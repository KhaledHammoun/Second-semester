package S07_MVVM_Sockets.Ex12_3.server.mediator;


import S07_MVVM_Sockets.Ex12_3.server.model.Radiator;
import S07_MVVM_Sockets.Ex12_3.shared.external.Temperature;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class HeaterModelManager implements HeaterModel
{
  private Temperature minTemperature;
  private Temperature maxTemperature;
  private Radiator radiator;
  private PropertyChangeSupport support = new PropertyChangeSupport(this);
  private String warningTextOld = "";
  private  String warningColourOld = "#ffffff00";

  public HeaterModelManager()
  {
    minTemperature = new Temperature("minTemp", Double.MIN_VALUE);
    maxTemperature = new Temperature("maxTemp", Double.MAX_VALUE);
    radiator = new Radiator(support);
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
