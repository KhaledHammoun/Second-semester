package MVVM.Ex4_4.temperature.mediator;

import MVVM.Ex4_4.temperature.model.Temperature;
import MVVM.Ex4_4.temperature.model.TemperatureList;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class TemperatureModelManager implements TemperatureModel
{
  private TemperatureList temperatureList;

  public TemperatureModelManager()
  {
    temperatureList = new TemperatureList();
  }

  @Override public void addTemperature(String id, double value)
  {
    Temperature temperature = new Temperature(id, value);
    //Temperature old = getLastInsertedTemperature();
    this.temperatureList.addTemperature(temperature);
  }

  @Override public Temperature getLastInsertedTemperature()
  {
    return temperatureList.getLastTemperature(null);
  }

  @Override public Temperature getLastInsertedTemperature(String id)
  {
    return temperatureList.getLastTemperature(id);
  }

  // and maybe other methods...
}
