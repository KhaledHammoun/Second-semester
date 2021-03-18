package shared;

import shared.util.Status;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;

public class Users implements Serializable
{
  private PropertyChangeSupport support = new PropertyChangeSupport(this);
  private List<User> users;

  public Users()
  {
    users = new ArrayList<>();
  }

  public Users(List<User> users)
  {
    this.users = users;
  }

  public void addUser(User user)
  {
    if (!(users.contains(user)))
    {
      users.add(user);
    }
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

  public List<User> getAllUsers()
  {
    return users;
  }

  public Users copy()
  {
    return new Users(getAllUsers());
  }

  public boolean equals(Object obj)
  {
    if (!(obj instanceof Users))
    {
      return false;
    }
    Users other = (Users) obj;

    return this.users.equals(other.users);
  }
}
