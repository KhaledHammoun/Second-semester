package MVVM.Ex4_3.view.log;

import MVVM.Ex4_3.model.TextConverter;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class LogViewModel
{
  private TextConverter textConverter;
  private ObservableList<String> logs;

  public LogViewModel(TextConverter textConverter)
  {
    this.textConverter = textConverter;
    logs = FXCollections.observableArrayList();
  }

  public ObservableList<String> getLogs()
  {
    return logs;
  }

  public void loadLogs()
  {
    // TODO: 21-02-2021  Is it the right way?
    logs.clear();
    logs.addAll(textConverter.getLogs());
  }
}
