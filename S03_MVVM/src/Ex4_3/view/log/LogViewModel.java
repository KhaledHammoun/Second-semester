package Ex4_3.view.log;

import Ex4_3.model.TextConverter;
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
    logs.clear();
    logs.addAll(textConverter.getLogs());
  }
}
