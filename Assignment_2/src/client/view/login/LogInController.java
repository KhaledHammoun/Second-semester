package client.view.login;

import client.core.ViewHandler;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

public class LogInController
{
  @FXML private TextField userNameTextField;
  private LogInViewModel logInViewModel;
  private ViewHandler viewHandler;

  public void init(LogInViewModel logInViewModel, ViewHandler viewHandler)
  {
    this.logInViewModel = logInViewModel;
    this.viewHandler = viewHandler;
    userNameTextField.textProperty().bindBidirectional(
        logInViewModel.usernameProperty());
  }

  @FXML public void onLogInButton()
  {
    logInViewModel.LogIn();
    viewHandler.startView("chat");
  }

  @FXML public void onInfoButton(ActionEvent actionEvent)
  {
    Alert info = new Alert(Alert.AlertType.INFORMATION);
    info.setContentText("Type your username if existing user and press Login."
        + "\nIf a new user, type your preferred username and press log in. The system"
        + " will automatically create your account.");
    info.setHeaderText("INFO");
    info.setHeight(300);
    info.show();
  }

  @FXML public void onEnterPressed(ActionEvent keyEvent)
  {
      onLogInButton();
  }
}
