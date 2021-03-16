package Ex5_3.view.showtask;

import Ex5_3.core.ViewHandler;
import Ex5_3.model.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class ShowTaskController
{

  @FXML private TableView<Task> tasksTable;
  @FXML private TableColumn<String, Task> creatorColumn;
  @FXML private TableColumn<String, Task> descriptionColumn;
  @FXML private TableColumn<String, Task> dateColumn;
  private ViewHandler viewHandler;
  private ShowTaskViewModel showTaskViewModel;

  @FXML public void onAddButton(ActionEvent actionEvent)
  {
    viewHandler.start("add");
  }

  @FXML public void onNextTaskButton(ActionEvent actionEvent)
  {
    viewHandler.start("next");
  }

  public void init(ViewHandler viewHandler, ShowTaskViewModel showTaskViewModel)
  {
    this.viewHandler = viewHandler;
    this.showTaskViewModel = showTaskViewModel;
    creatorColumn.setCellValueFactory(new PropertyValueFactory<>("owner"));
    descriptionColumn.setCellValueFactory((new PropertyValueFactory<>("description")));
    dateColumn.setCellValueFactory(new PropertyValueFactory<>("timeCreated"));
    tasksTable.setItems(showTaskViewModel.getTaskList());
  }
}
