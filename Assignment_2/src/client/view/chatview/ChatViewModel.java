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
  private StringBuilder newMessage;


  public ChatViewModel(ChatModel chatModel)
  {
    this.chatModel = chatModel;
    message = new SimpleStringProperty();
    messageToSend = new SimpleStringProperty();
    newMessage = new StringBuilder();
    chatModel.addPropertyChangeListener(RequestType.NEWMESSAGE.toString(),
        (x) -> setMessage((Message) x.getNewValue()));
  }

  private void setMessage(Message message)
  {
    newMessage.append(message + "\n\n");
    this.message.set(newMessage.toString());
  }

  public void sendMessage()
  {
    Message message = new Message(chatModel.getCurrentUser(), messageToSend.get());
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

  public void clear()
  {
    message.set("");
    messageToSend.set("");
  }
}
