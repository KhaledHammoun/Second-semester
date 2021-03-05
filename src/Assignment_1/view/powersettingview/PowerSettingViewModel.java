package Assignment_1.view.powersettingview;

import Assignment_1.mediator.HeaterModel;
import Assignment_1.util.PropertyChangeSubject;
import javafx.application.Platform;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.beans.PropertyChangeEvent;

public class PowerSettingViewModel
{
  private StringProperty minTemperature;
  private StringProperty maxTemperature;
  private StringProperty powerLevel;
  private HeaterModel heaterModel;

  public PowerSettingViewModel(HeaterModel heaterModel)
  {
    this.heaterModel = heaterModel;
    minTemperature = new SimpleStringProperty();
    maxTemperature = new SimpleStringProperty();
    powerLevel = new SimpleStringProperty("0");

    ((PropertyChangeSubject)heaterModel).addPropertyChangeListener("HeatingChange", this::setPowerLevel);
  }

  public void setAlert()
  {
    double tMin = Double.parseDouble(minTemperature.getValue());
    double tMax = Double.parseDouble(maxTemperature.getValue());
    heaterModel.setMinMaxTemperature(tMin, tMax);
  }

  public StringProperty minTemperatureProperty()
  {
    return minTemperature;
  }

  public StringProperty maxTemperatureProperty()
  {
    return maxTemperature;
  }

  public StringProperty powerLevelProperty()
  {
    return powerLevel;
  }

  public void setPowerLevel(PropertyChangeEvent event)
  {
    Platform.runLater(() -> {
      String powerLevel = event.getNewValue().toString();
      this.powerLevel.set(powerLevel);
    });
  }

  public void powerUp()
  {
    heaterModel.turnPowerUp();
  }

  public void powerDown()
  {
    heaterModel.turnPowerDown();
  }
}
