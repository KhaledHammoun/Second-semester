package client.view.login;

import client.model.ChatModel;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

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
    System.out.println("LogIn viewModel");

  }

  public StringProperty usernameProperty()
  {
    return username;
  }
}
