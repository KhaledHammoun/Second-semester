package shared;

import server.network.ServerSocketHandler;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Users implements Serializable
{
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

  public User getUserForClient(User user)
  {
    User temp = users.get(users.indexOf(user));
    temp.removeReference();
    return temp;
  }

  public ServerSocketHandler getReference(User user)
  {
    return users.get(users.indexOf(user)).getReference();
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

  public String toString()
  {
    return users.toString();
  }
}
