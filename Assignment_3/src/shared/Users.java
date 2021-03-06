package shared;


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

  public List<User> getAllUsers()
  {
    return users;
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
