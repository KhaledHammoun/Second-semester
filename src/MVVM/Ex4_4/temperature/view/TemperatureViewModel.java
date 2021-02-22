package MVVM.Ex4_4.temperature.view;

import MVVM.Ex4_4.temperature.mediator.TemperatureModel;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ObservableValue;

public class TemperatureViewModel
{
  private StringProperty temperature;
  private TemperatureModel model;

  public TemperatureViewModel(TemperatureModel model)
  {
    this.model = model;
    temperature = new SimpleStringProperty("Press update button to get temperature.");
  }

  public void getLastTemp(String thermometer)
  {
    if (thermometer == null)
    {
      temperature.set(model.getLastInsertedTemperature().toString());
    }
    else
    {
      temperature.set(model.getLastInsertedTemperature(thermometer).toString());

    }
  }

  public StringProperty temperature()
  {
    return temperature;
  }
}
