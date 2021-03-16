package client.model;

import client.network.Client;
import shared.Message;
import shared.RequestType;
import shared.User;
import shared.Users;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.List;

public class ChatModelManager implements ChatModel
{
  private User currentUser;
  private Client client;
  private PropertyChangeSupport support = new PropertyChangeSupport(this);

  public ChatModelManager(Client client)
  {
    this.client = client;
    client.addPropertyChangeListener(RequestType.NEWMESSAGE.toString(), (x) -> receiveMessage((Message) x.getNewValue()));
  }

  @Override public void addUser(User user)
  {

  }

  @Override public void addFriend(User user, User friend)
  {

  }

  @Override public void sendMessage(Message message)
  {

  }

  @Override public Users getAllUsers()
  {
    return null;
  }

  @Override public List<User> getFriends()
  {
    return null;
  }

  @Override public void receiveMessage(Message message)
  {

  }

  @Override public void setCurrentUser(User user)
  {
    currentUser = user;
  }

  @Override public User getCurrentUser()
  {
    return currentUser;
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
    if (name == null)
    {
      support.removePropertyChangeListener(listener);
    }
    else
    {
      support.removePropertyChangeListener(name, listener);
    }
  }
}
