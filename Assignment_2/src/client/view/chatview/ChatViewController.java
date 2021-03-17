package client.view.chatview;

import client.core.ViewHandler;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

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
    receiveMessageTextArea.textProperty().bind(chatViewModel.messageProperty());
    messageTextArea.textProperty().bindBidirectional(
        chatViewModel.messageToSendProperty());
  }

  @FXML public void onExitButton()
  {
    viewHandler.startView("logIn");
    chatViewModel.clear();
  }

  @FXML public void onFriendsButton()
  {
    viewHandler.startView("friends");
  }

  @FXML public void onSendMessageButton()
  {
    chatViewModel.sendMessage();
    messageTextArea.clear();
    receiveMessageTextArea.setScrollTop(Double.MAX_VALUE);
  }


  public void onEnter(KeyEvent keyEvent)
  {
    if (keyEvent.getCode().equals(KeyCode.ENTER))
    {
      onSendMessageButton();
    }
  }
}
