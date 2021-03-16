package Ex12_3.view.mainview;


import Ex12_3.mediator.HeaterModel;
import S07_MVVM_Sockets.Ex12_3.shared.Temperature;
import S07_MVVM_Sockets.Ex12_3.shared.util.PropertyChangeSubject;
import javafx.application.Platform;
import javafx.beans.property.Property;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.paint.Paint;

import java.beans.PropertyChangeEvent;

public class MainViewModel
{
  private StringProperty outsideTemperature;
  private StringProperty insideOneTemperature;
  private StringProperty insideTwoTemperature;
  private Property<Paint> warningColour;


  private StringProperty warningMessage;
  private HeaterModel heaterModel;

  public MainViewModel(HeaterModel heaterModel)
  {
    this.heaterModel = heaterModel;
    outsideTemperature = new SimpleStringProperty("");
    insideOneTemperature = new SimpleStringProperty("Close to heater: ");
    insideTwoTemperature = new SimpleStringProperty("Further from heater: ");
    warningColour = new SimpleObjectProperty<>(Paint.valueOf("#ffffff00"));
    warningMessage = new SimpleStringProperty("");

    ((PropertyChangeSubject)heaterModel).addPropertyChangeListener("t0", this::setOutsideTemperature);
    ((PropertyChangeSubject)heaterModel).addPropertyChangeListener("t1", this::setInsideOneTemperature);
    ((PropertyChangeSubject)heaterModel).addPropertyChangeListener("t2", this::setInsideTwoTemperature);
    ((PropertyChangeSubject)heaterModel).addPropertyChangeListener("warningColour", this::setWarningColour);
    ((PropertyChangeSubject)heaterModel).addPropertyChangeListener("warningText", this::setWarningMessage);
  }

  public void setOutsideTemperature(PropertyChangeEvent event)
  {
    Platform.runLater(() -> {
      double outsideTemperature =((Temperature)event.getNewValue()).getValue();
      this.outsideTemperature.set(""+outsideTemperature);
    });
  }

  public void setInsideOneTemperature(PropertyChangeEvent event)
  {
    Platform.runLater(() -> {
      double insideOneTemperature =((Temperature)event.getNewValue()).getValue();
      this.insideOneTemperature.set("Close to heater: "+insideOneTemperature);
    });
  }

  public void setInsideTwoTemperature(PropertyChangeEvent event)
  {
    Platform.runLater(() -> {
      double insideTwoTemperature =((Temperature)event.getNewValue()).getValue();
      this.insideTwoTemperature.set("Further from heater: "+insideTwoTemperature);
    });
  }

  public void setWarningColour(PropertyChangeEvent event)
  {
    Platform.runLater(() -> {
      String warningColour = event.getNewValue().toString();
      this.warningColour.setValue(Paint.valueOf(warningColour));
    });
  }

  public void setWarningMessage(PropertyChangeEvent event)
  {
    Platform.runLater(() -> {
      String warningMessage = event.getNewValue().toString();
      this.warningMessage.set(warningMessage);
    });
  }

  public StringProperty outsideTemperatureProperty()
  {
    return outsideTemperature;
  }

  public StringProperty insideOneTemperatureProperty()
  {
    return insideOneTemperature;
  }

  public StringProperty insideTwoTemperatureProperty()
  {
    return insideTwoTemperature;
  }

  public Property<Paint> warningColourProperty()
  {
    return warningColour;
  }

  public StringProperty warningMessageProperty()
  {
    return warningMessage;
  }
}
