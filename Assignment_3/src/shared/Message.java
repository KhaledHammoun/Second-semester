package shared;

import java.io.Serializable;
import java.util.Date;

public class Message implements Serializable
{
  private User user;
  private String message;

  public Message(User user, String message)
  {
    this.user = user;
    this.message = message;
    if (message== null || message.isBlank())
      this.message = ":)";
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
    return "From: " + user + " - " + new Date() + "\n" + message;
  }
}
