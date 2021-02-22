package MVVM.Ex4_3.view.uppercase;

import MVVM.Ex4_3.core.ViewHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class UppercaseViewController
{
  @FXML private TextField requestField;
  @FXML private TextField replyField;
  @FXML private Button submitButton;
  @FXML private Label errorLabel;

  private UppercaseViewModel viewModel;
  private ViewHandler viewHandler;

  public void init(UppercaseViewModel viewModel, ViewHandler viewHandler)
  {
    this.viewModel = viewModel;
    this.viewHandler = viewHandler;
    requestField.textProperty().bindBidirectional(viewModel.requestProperty());
    replyField.textProperty().bind(viewModel.replyProperty());
    errorLabel.textProperty().bind(viewModel.errorProperty());
  }

  @FXML public void onButtonClick()
  {
    viewModel.convert();
  }

  public void onEnter(KeyEvent keyEvent)
  {
    if (keyEvent.getCode().equals(KeyCode.ENTER))
    {
      onButtonClick();
    }
  }

  @FXML public void onShow()
  {
    viewModel.clear();
    try
    {
      viewHandler.start("Log");
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }
  }
}
