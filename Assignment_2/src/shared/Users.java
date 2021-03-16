package shared;

import shared.util.Status;

import java.util.ArrayList;

public class Users
{
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

  public Status getStatus(User user)
  {
    return user.getStatus();
  }
}
