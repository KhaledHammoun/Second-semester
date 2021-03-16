package shared;

import shared.util.Status;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.Date;

public class Users
{
  private PropertyChangeSupport support = new PropertyChangeSupport(this);
  private ArrayList<User> users;

  public Users()
  {
    users = new ArrayList<>();
  }

  public void addUser(User user)
  {
    users.add(user);
  }

  public User getUser(User user)
  {
    if (users.contains(user))
    {
      return user;
    }
    addUser(user);
    return user;
  }

  public void addFriend(User user, User friend)
  {
    user.addFriend(friend);
  }
}
