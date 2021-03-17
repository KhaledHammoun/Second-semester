package server.model;

import shared.Message;
import shared.RequestType;
import shared.User;
import shared.Users;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.List;

public class ChatModelManager implements ChatModel
{
  private Users users;
  private PropertyChangeSupport support = new PropertyChangeSupport(this);

  public ChatModelManager()
  {
    users = new Users();
  }

  @Override public void addUser(User user)
  {
    users.addUser(user);
    support.firePropertyChange(RequestType.NEWUSER.toString(), null, user);
  }

  @Override public void addFriend(User user, User friend)
  {
    users.addFriend(user, friend);
    support.firePropertyChange(RequestType.NEWFRIEND.toString(), user,friend);
  }

  @Override public void sendMessage(Message message)
  {
    support.firePropertyChange(RequestType.NEWMESSAGE.toString(), null, message);
  }

  @Override public Users getAllUsers()
  {
    return users;
  }

  @Override public List<User> getFriends(User currentUser)
  {
    return users.getUser(currentUser).getFriends();
  }

  @Override public void receiveMessage(Message message)
  {

  }

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
}
