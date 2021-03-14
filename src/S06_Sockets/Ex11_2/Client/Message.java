package S06_Sockets.Ex11_2.Client;

public class Message
{
  private String message;

  public Message(String message)
  {
    this.message = message;
  }

  public String getMessage()
  {
    return message;
  }

  public String toUpperCase()
  {
    return message.toUpperCase();
  }
}
