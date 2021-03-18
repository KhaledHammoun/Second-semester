package shared;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class User implements Serializable
{
  private String username;
  private Date registered;
  private List<User> friends;

  public User(String userName)
  {
    this.username = userName;
    registered = new Date();
    friends = new ArrayList<>();
  }

  public String getUsername()
  {
    return username;
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

  public Date getRegistered()
  {
    return registered;
  }

  public boolean equals(Object obj)
  {
    if(!(obj instanceof User))
    {
      return false;
    }
    User other = (User) obj;

    return this.username.equals(other.username);
  }
  public String toString()
  {
    return username;
  }
}
