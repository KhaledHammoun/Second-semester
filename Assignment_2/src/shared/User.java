package shared;

import shared.util.Status;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class User implements Serializable
{
  private String userName;
  private Status status;
  private List<User> friends;

  public User(String userName)
  {
    this.userName = userName;
    friends = new ArrayList<>();
  }

  public String getUserName()
  {
    return userName;
  }

  public List<User> getFriends()
  {
    return friends;
  }

  public User getFriend(User user)
  {
    if (friends.contains(user))
    {
      return friends.get(friends.indexOf(user));
    }
    return null;
  }

  public void addFriend(User user)
  {
    if (!(friends.contains(user)))
    {
      friends.add(user);
    }
  }

  public void setStatus()
  {
    // TODO: 16-03-2021 Set the status acording to logged in.
  }

  public Status getStatus()
  {
    return status;
  }
}
