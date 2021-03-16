package Ex5_3.view.addtask;

import Ex5_3.core.ViewHandler;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class AddTaskController
{
  @FXML private TextField creatorTextField;
  @FXML private TextField descriptionTextField;
  private ViewHandler viewHandler;
  private AddTaskViewModel addTaskViewModel;

  @FXML public void onAddButton(ActionEvent actionEvent)
  {
    addTaskViewModel.addTask();
  }

  @FXML public void onBackButton(ActionEvent actionEvent)
  {
    viewHandler.start("main");
  }

  public void init(ViewHandler viewHandler, AddTaskViewModel addTaskViewModel)
  {
    this.viewHandler = viewHandler;
    this.addTaskViewModel = addTaskViewModel;

    creatorTextField.textProperty().bindBidirectional(addTaskViewModel.creatorProperty());
    descriptionTextField.textProperty().bindBidirectional(addTaskViewModel.descriptionProperty());
  }
}
