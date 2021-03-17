package client.core;

import client.view.chatview.ChatViewModel;
import client.view.findfriends.FindFriendsController;
import client.view.findfriends.FindFriendsViewModel;
import client.view.friends.FriendsViewModel;
import client.view.login.LogInViewModel;

public class ViewModelFactory
{
  private ModelFactory modelFactory;
  private LogInViewModel logInViewModel;
  private FriendsViewModel friendsViewModel;
  private ChatViewModel chatViewModel;
  private FindFriendsViewModel findFriendsViewModel;

  public ViewModelFactory(ModelFactory modelFactory)
  {
    this.modelFactory = modelFactory;
    this.logInViewModel = new LogInViewModel(modelFactory.getChatModel());
    this.findFriendsViewModel = new FindFriendsViewModel(modelFactory.getChatModel());
    this.chatViewModel = new ChatViewModel(modelFactory.getChatModel());
    this.friendsViewModel = new FriendsViewModel(modelFactory.getChatModel());
  }

  public LogInViewModel getLogInViewModel()
  {
    if (logInViewModel == null)
    {
      logInViewModel = new LogInViewModel(modelFactory.getChatModel());
    }
    return logInViewModel;
  }

  public FriendsViewModel getFriendsViewModel()
  {
    if (friendsViewModel == null)
    {
      friendsViewModel = new FriendsViewModel(modelFactory.getChatModel());
    }
    return friendsViewModel;
  }

  public ChatViewModel getChatViewModel()
  {
    if (chatViewModel == null)
    {
      chatViewModel = new ChatViewModel(modelFactory.getChatModel());
    }
    return chatViewModel;
  }

  public FindFriendsViewModel getFindFriendsViewModel()
  {
    if (findFriendsViewModel == null)
    {
      findFriendsViewModel = new FindFriendsViewModel(modelFactory.getChatModel());
    }
    return findFriendsViewModel;
  }
}
