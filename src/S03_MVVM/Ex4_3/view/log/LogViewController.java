package S03_MVVM.Ex4_3.view.log;

import S03_MVVM.Ex4_3.core.ViewHandler;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;

import java.io.IOException;

public class LogViewController
{
  @FXML private ListView<String> logList;
  private LogViewModel viewModel;
  private ViewHandler viewHandler;

  public void init(ViewHandler viewHandler, LogViewModel viewModel)
  {
    this.viewModel = viewModel;
    this.viewHandler = viewHandler;

    logList.setItems(viewModel.getLogs());
    viewModel.loadLogs();
  }

  @FXML public void onBack(ActionEvent actionEvent)
  {
    try
    {
      viewHandler.openView("uppercase");
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
  }
}
