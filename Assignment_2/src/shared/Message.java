package shared;

import java.io.Serializable;

public class Message implements Serializable
{
  private User user;
  private String message;

  public Message(User user, String message)
  {
    this.user = user;
    this.message = message;
  }

  public User getUser()
  {
    return user;
  }

  public String getMessage()
  {
    return message;
  }

  public String toString()
  {
    return "From: " + user + "\n" + message;
  }
}
