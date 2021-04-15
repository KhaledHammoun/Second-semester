package client.core;

import client.view.chatview.ChatViewModel;
import client.view.findfriends.FindFriendsViewModel;
import client.view.friends.FriendsViewModel;
import client.view.login.LogInViewModel;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ViewModelFactory
{
  private ModelFactory modelFactory;
  private LogInViewModel logInViewModel;
  private FriendsViewModel friendsViewModel;
  private ChatViewModel chatViewModel;
  private FindFriendsViewModel findFriendsViewModel;
  private static ViewModelFactory viewModelFactory;
  private static Lock lock = new ReentrantLock();

  private ViewModelFactory()
  {
    this.modelFactory = ModelFactory.getModelFactory();
    this.logInViewModel = new LogInViewModel(modelFactory.getChatModel());
    this.findFriendsViewModel = new FindFriendsViewModel(modelFactory.getChatModel());
    this.chatViewModel = new ChatViewModel(modelFactory.getChatModel());
    this.friendsViewModel = new FriendsViewModel(modelFactory.getChatModel());
  }

  public static ViewModelFactory getViewModelFactory()
  {
    if (viewModelFactory == null)
    {
      synchronized (lock)
      {
        if (viewModelFactory == null)
        {
          viewModelFactory = new ViewModelFactory();
        }
      }
    }
    return viewModelFactory;
  }

  public LogInViewModel getLogInViewModel()
  {
    return logInViewModel;
  }

  public FriendsViewModel getFriendsViewModel()
  {
    return friendsViewModel;
  }

  public ChatViewModel getChatViewModel()
  {
    return chatViewModel;
  }

  public FindFriendsViewModel getFindFriendsViewModel()
  {
    return findFriendsViewModel;
  }
}
