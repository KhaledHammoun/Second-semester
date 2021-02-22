package MVVM.Ex4_2.viewmodel;

import MVVM.Ex4_2.model.TextConverter;
import MVVM.Ex4_2.model.TextConverterModel;
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
}
