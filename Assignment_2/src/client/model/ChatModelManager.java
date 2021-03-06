package client.model;

import client.network.Client;
import shared.Message;
import shared.RequestType;
import shared.User;
import shared.Users;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class ChatModelManager implements ChatModel
{
  private User currentUser;
  private Client client;
  private PropertyChangeSupport support = new PropertyChangeSupport(this);

  public ChatModelManager(Client client)
  {
    this.client = client;
    client.startClient();
    client.addPropertyChangeListener(RequestType.NEWMESSAGE.toString(),
        this::receiveMessage);
    client.addPropertyChangeListener(RequestType.NEWFRIEND.toString(),
        this::getFriends);
    client.addPropertyChangeListener(RequestType.NEWUSER.toString(),
        this::newUsersAdded);
    client.addPropertyChangeListener(RequestType.GETCONNECTIONS.toString(),
        this::numberOfConnections);
  }

  private void numberOfConnections(PropertyChangeEvent event)
  {
    support.firePropertyChange(event);
  }

  private void newUsersAdded(PropertyChangeEvent event)
  {
    Users users = (Users) event.getNewValue();
    support
        .firePropertyChange(RequestType.NEWUSER.toString(), null, users.copy());
  }

  @Override public void addUser(User user)
  {
    client.addUser(user);
  }

  @Override public void addFriend(User friend)
  {
    client.addFriend(currentUser, friend);
  }

  @Override public void sendMessage(Message message)
  {
    client.sendMessage(message);
  }

  @Override public void getFriends(PropertyChangeEvent event)
  {
    support.firePropertyChange(event);
  }

  @Override public void receiveMessage(PropertyChangeEvent event)
  {
    support.firePropertyChange(event);
  }

  @Override public void setCurrentUser(User user)
  {
    currentUser = user;
    support.firePropertyChange(RequestType.CURRENTUSER.toString(), null,
        currentUser);
  }

  @Override public User getCurrentUser()
  {
    return currentUser;
  }

  @Override public void getNumberOfConnections()
  {
    client.getNumberOfConnections();
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
