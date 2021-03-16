package Ex12_3.client.view.logsview;



import Ex12_3.shared.Temperature;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class LogsViewController
{
  @FXML private TableView<Temperature> innerOneThermTable;
  @FXML private TableColumn<String, Temperature> innerOneThermReadingColumn;
  @FXML private TableColumn<String, Temperature> innerOneThermTimeColumn;
  @FXML private TableView<Temperature> innerTwoThermTable;
  @FXML private TableColumn<String, Temperature> innerTwoThermReadingColumn;
  @FXML private TableColumn<String, Temperature> innerTwoThermTimeColumn;
  @FXML private TableView<Temperature> outerThermTable;
  @FXML private TableColumn<String, Temperature> outerThermReadingColumn;
  @FXML private TableColumn<String, Temperature> outerThermTimeColumn;
  private LogsViewModel viewModel;

  public void init(LogsViewModel viewModel)
  {
    this.viewModel = viewModel;

    innerOneThermReadingColumn.setCellValueFactory(new PropertyValueFactory<>("value"));
    innerOneThermTimeColumn.setCellValueFactory(new PropertyValueFactory<>("timeStamp"));
    innerOneThermTable.setItems(viewModel.getInsideOneTempLogs());

    innerTwoThermReadingColumn.setCellValueFactory(new PropertyValueFactory<>("value"));
    innerTwoThermTimeColumn.setCellValueFactory(new PropertyValueFactory<>("timeStamp"));
    innerTwoThermTable.setItems(viewModel.getInsideTwoTempLogs());

    outerThermReadingColumn.setCellValueFactory(new PropertyValueFactory<>("value"));
    outerThermTimeColumn.setCellValueFactory(new PropertyValueFactory<>("timeStamp"));
    outerThermTable.setItems(viewModel.getOutsideTempLogs());
  }
}
