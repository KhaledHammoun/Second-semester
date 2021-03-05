package Assignment_1.view.logsview;

import Assignment_1.mediator.HeaterModel;
import Assignment_1.model.Temperature;
import Assignment_1.util.PropertyChangeSubject;
import S04_MVVM_Observer.Ex5_3.model.Task;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.beans.PropertyChangeEvent;
import java.sql.Array;

public class LogsViewModel
{
  private ObservableList<Temperature> outsideTempLogs;
  private ObservableList<Temperature> insideOneTempLogs;
  private ObservableList<Temperature> insideTwoTempLogs;
  private HeaterModel heaterModel;

  public LogsViewModel(HeaterModel heaterModel)
  {
    this.heaterModel = heaterModel;
    outsideTempLogs = FXCollections.observableArrayList();
    insideOneTempLogs = FXCollections.observableArrayList();
    insideTwoTempLogs = FXCollections.observableArrayList();

    ((PropertyChangeSubject)heaterModel).addPropertyChangeListener("t0", this::addOuterTemp);
    ((PropertyChangeSubject)heaterModel).addPropertyChangeListener("t2", this::addInnerTemp);
    ((PropertyChangeSubject)heaterModel).addPropertyChangeListener("t1", this::addInnerTemp);
  }

  private void removeTemp(ObservableList<Temperature> list)
  {
    if (list.size() > 10)
    {
      list.remove(0);
    }
  }

  public void addInnerTemp(PropertyChangeEvent evt)
  {
    Platform.runLater(() -> {
      Temperature temperature = (Temperature) evt.getNewValue();
      if (evt.getPropertyName().equals("t1"))
      {
        insideOneTempLogs.add(temperature);
        removeTemp(insideOneTempLogs);
      }
      else
      {
        insideTwoTempLogs.add(temperature);
        removeTemp(insideTwoTempLogs);
      }
    });
  }

  public void addOuterTemp(PropertyChangeEvent evt)
  {
    Temperature temperature = (Temperature) evt.getNewValue();
    outsideTempLogs.add(temperature);
    removeTemp(outsideTempLogs);
  }
  public ObservableList<Temperature> getOutsideTempLogs()
  {
    return outsideTempLogs;
  }

  public ObservableList<Temperature> getInsideOneTempLogs()
  {
    return insideOneTempLogs;
  }

  public ObservableList<Temperature> getInsideTwoTempLogs()
  {
    return insideTwoTempLogs;
  }
}
