package shared;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable
{
  private String username;
  private Date registered;

  public User(String userName)
  {
    this.username = userName;
    registered = new Date();
  }

  public String getUsername()
  {
    return username;
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
