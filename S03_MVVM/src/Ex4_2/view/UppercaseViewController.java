package Ex4_2.view;

import Ex4_2.viewmodel.UppercaseViewModel;
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

  public void init(UppercaseViewModel viewModel)
  {
    this.viewModel = viewModel;
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
}
