package Ex4_3.core;

import Ex4_3.model.TextConverter;
import Ex4_3.model.TextConverterModel;

public class ModelFactory
{
  private TextConverter textConverter;

  public TextConverter getTextConverter()
  {
    if (textConverter == null)
    {
      textConverter = new TextConverterModel();
    }
    return textConverter;
  }
}
