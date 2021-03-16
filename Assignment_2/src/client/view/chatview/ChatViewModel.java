package client.view.chatview;

import client.model.ChatModel;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import shared.Message;
import shared.RequestType;

import java.beans.PropertyChangeEvent;

public class ChatViewModel
{
  private ChatModel chatModel;
  private StringProperty message;
  private StringProperty messageToSend;

  public ChatViewModel(ChatModel chatModel)
  {
    this.chatModel = chatModel;
    message = new SimpleStringProperty();
    messageToSend = new SimpleStringProperty();
    chatModel.addPropertyChangeListener(RequestType.NEWMESSAGE.toString(),
        (x) -> setMessage((Message) x.getNewValue()));
  }

  private void setMessage(Message message)
  {
    String newMessage = this.message.getValue() + "\n\n" + message;
    this.message.set(newMessage);
  }

  public void sendMessage()
  {
    Message message = new Message(chatModel.getCurrentUser(), messageToSend.get());
    setMessage(message);
    chatModel.sendMessage(message);
  }

  public StringProperty messageProperty()
  {
    return message;
  }

  public StringProperty messageToSendProperty()
  {
    return messageToSend;
  }
}
