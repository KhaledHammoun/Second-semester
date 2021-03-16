package client.view.findfriends;

import client.model.ChatModel;
import shared.User;

public class FindFriendsViewModel
{
  private ChatModel chatModel;

  public FindFriendsViewModel(ChatModel chatModel)
  {

    this.chatModel = chatModel;
  }

  public void addFriend(User user)
  {
    System.out.println("Hello from VW(Add friend)");
  }
}
