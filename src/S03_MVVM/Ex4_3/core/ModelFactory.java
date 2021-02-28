package S03_MVVM.Ex4_3.core;

import S03_MVVM.Ex4_3.model.TextConverter;
import S03_MVVM.Ex4_3.model.TextConverterModel;

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
