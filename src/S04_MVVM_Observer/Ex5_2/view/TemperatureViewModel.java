package S04_MVVM_Observer.Ex5_2.view;

import S04_MVVM_Observer.Ex5_2.mediator.PropertyChangeSubject;
import S04_MVVM_Observer.Ex5_2.mediator.TemperatureModel;
import javafx.application.Platform;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class TemperatureViewModel
{
  private StringProperty temperature;
  private TemperatureModel model;

  public TemperatureViewModel(TemperatureModel model)
  {
    this.model = model;
    temperature = new SimpleStringProperty("Wait...");
    ((PropertyChangeSubject)model).addPropertyChangeListener((x) -> getLastTemp(null));
  }

  public void getLastTemp(String thermometer)
  {
    Platform.runLater(() -> {
      if (thermometer == null || thermometer.equals("All"))
      {
        temperature.set(model.getLastInsertedTemperature().toString());
      }
      else
      {
        temperature.set(model.getLastInsertedTemperature(thermometer).toString());
      }
    });
  }

  public StringProperty temperature()
  {
    return temperature;
  }

}
