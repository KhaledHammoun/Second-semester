package client.view.login;

import client.model.ChatModel;

public class LogInViewModel
{
  private ChatModel chatModel;

  public LogInViewModel(ChatModel chatModel)
  {
    this.chatModel = chatModel;
  }

  public void LogIn()
  {
    System.out.println("LogIn viewModel");
  }
}
