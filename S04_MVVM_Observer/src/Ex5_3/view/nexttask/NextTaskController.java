package Ex5_3.view.nexttask;

import Ex5_3.core.ViewHandler;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class NextTaskController
{
  @FXML private Label taskNameLabel;
  @FXML private Label createdByLabel;
  @FXML private Label createdAtLabel;
  private ViewHandler viewHandler;
  private NextTaskViewModel nextTaskViewModel;

  @FXML public void ogGetTaskButton(ActionEvent actionEvent)
  {
    nextTaskViewModel.getTask();
  }

  @FXML public void ogBackButton(ActionEvent actionEvent)
  {
    viewHandler.start("main");
  }

  public void init(ViewHandler viewHandler, NextTaskViewModel nextTaskViewModel)
  {
    this.viewHandler = viewHandler;
    this.nextTaskViewModel = nextTaskViewModel;

    taskNameLabel.textProperty().bind(nextTaskViewModel.taskProperty());
    createdByLabel.textProperty().bind(nextTaskViewModel.creatorProperty());
    createdAtLabel.textProperty().bind(nextTaskViewModel.dateProperty());
  }
}
