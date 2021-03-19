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
  private StringProperty user;
  private StringProperty numberOfConnections;


  public ChatViewModel(ChatModel chatModel)
  {
    this.chatModel = chatModel;
    message = new SimpleStringProperty();
    messageToSend = new SimpleStringProperty();
    newMessage = new StringBuilder();
    user = new SimpleStringProperty("Logged in as: ");
    numberOfConnections = new SimpleStringProperty("Number of users");

    chatModel.addPropertyChangeListener(RequestType.NEWMESSAGE.toString(),
        (x) -> setMessage((Message) x.getNewValue()));
    chatModel.addPropertyChangeListener(RequestType.CURRENTUSER.toString(), this::setUser);
    chatModel.addPropertyChangeListener(RequestType.GETCONNECTIONS.toString(), this::numberOfConnections);
  }

  private void numberOfConnections(PropertyChangeEvent event)
  {
    String connected = String.valueOf((int) event.getNewValue());
    numberOfConnections.set(connected);
  }

  private void setUser(PropertyChangeEvent event)
  {
    user.set("Logged in as: " + event.getNewValue());
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

  public void getNumberOfConnections()
  {
    chatModel.getNumberOfConnections();
  }

  public StringProperty messageProperty()
  {
    return message;
  }

  public StringProperty messageToSendProperty()
  {
    return messageToSend;
  }

  public StringProperty userProperty()
  {
    return user;
  }

  public StringProperty numberOfConnectionsProperty()
  {
    return numberOfConnections;
  }

  public void clear()
  {
    message.set("");
    messageToSend.set("");
  }
}
