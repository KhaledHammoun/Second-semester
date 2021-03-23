package shared;

import server.network.ServerSocketHandler;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class User implements Serializable
{
  private String username;
  private Date registered;
  private List<User> friends;
  private ServerSocketHandler reference;

  public User(String userName, ServerSocketHandler reference)
  {
    this.username = userName;
    registered = new Date();
    friends = new ArrayList<>();
    this.reference = reference;
  }

  public ServerSocketHandler getReference()
  {
    return reference;
  }

  public void removeReference()
  {
    reference = null;
  }
  public String getUsername()
  {
    return username;
  }

  public List<User> getFriends()
  {
    return friends;
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
