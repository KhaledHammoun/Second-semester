package Ex11_5.Client.ui;

import Ex11_5.Client.networking.ClientSocket;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class ChatController
{
  @FXML private TextField userNameTextField;
  @FXML private TextField messageTextField;
  private ClientSocket clientSocket;

  @FXML public void onSendButton(ActionEvent actionEvent)
  {
    clientSocket.sendMessage();
  }

  public void init(ClientSocket clientSocket)
  {
    this.clientSocket = clientSocket;
    messageTextField.textProperty().bindBidirectional(
        clientSocket.messageProperty());
  }
}
