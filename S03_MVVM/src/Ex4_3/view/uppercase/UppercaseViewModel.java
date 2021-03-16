package Ex4_3.view.uppercase;

import Ex4_3.model.TextConverter;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class UppercaseViewModel
{
  private TextConverter textConverter;
  private StringProperty request, reply, error;



  public UppercaseViewModel(TextConverter textConverter)
  {
    this.textConverter = textConverter;
    request = new SimpleStringProperty();
    reply = new SimpleStringProperty();
    error = new SimpleStringProperty();
  }

  public StringProperty requestProperty()
  {
    return request;
  }

  public StringProperty replyProperty()
  {
    return reply;
  }

  public StringProperty errorProperty()
  {
    return error;
  }

  public void convert()
  {
    if (request.get() == null || request.get().equals(""))
    {
      error.set("Enter text into request field");
    }
    else
    {
      error.set(null);
      reply.set(textConverter.toUppercase(request.get()));
    }
  }

  public void clear()
  {
    request.set("");
    reply.set("");
    error.set("");
  }
}
