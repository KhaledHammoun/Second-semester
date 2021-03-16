package client.view.chatview;

import client.core.ViewHandler;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

public class ChatViewController
{
  @FXML private TextArea receiveMessageTextArea;
  @FXML private TextArea messageTextArea;
  private ChatViewModel chatViewModel;
  private ViewHandler viewHandler;

  public void init(ChatViewModel chatViewModel, ViewHandler viewHandler)
  {
    this.chatViewModel = chatViewModel;
    this.viewHandler = viewHandler;
  }

  @FXML public void onExitButton()
  {
    viewHandler.startView("logIn");
  }

  @FXML public void onFriendsButton()
  {
    viewHandler.startView("friends");
  }

  @FXML public void onSendMessageButton()
  {
    System.out.println("Sending message");
  }
}
