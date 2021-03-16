package client.view.login;

import client.model.ChatModel;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import shared.User;

public class LogInViewModel
{
  private ChatModel chatModel;
  private StringProperty username;

  public LogInViewModel(ChatModel chatModel)
  {
    this.chatModel = chatModel;
    username = new SimpleStringProperty("Name");
  }

  public void LogIn()
  {
    chatModel.setCurrentUser(new User(username.getValue()));
  }

  public StringProperty usernameProperty()
  {
    return username;
  }
}
