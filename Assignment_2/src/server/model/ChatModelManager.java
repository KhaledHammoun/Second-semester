package server.model;

import shared.User;
import shared.Users;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class ChatModelManager implements ChatModel
{
  private Users users;
  private PropertyChangeSupport support = new PropertyChangeSupport(this);

  public ChatModelManager()
  {
    users = new Users();
  }
  // TODO: 16-03-2021 Method sendMessage that will fire a property with message send.
  @Override public void addPropertyChangeListener(String name,
      PropertyChangeListener listener)
  {
    if (name == null)
    {
      support.addPropertyChangeListener(listener);
    }
    else
    {
      support.addPropertyChangeListener(name, listener);
    }
  }

  @Override public void removePropertyChangeListener(String name,
      PropertyChangeListener listener)
  {
    if(name == null)
    {
      support.removePropertyChangeListener(listener);
    }
    else
    {
      support.removePropertyChangeListener(name, listener);
    }
  }

  @Override public void addFriend(User user, User friend)
  {
    users.addFriend(user, friend);
  }
}
