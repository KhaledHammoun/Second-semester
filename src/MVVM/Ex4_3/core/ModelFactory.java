package MVVM.Ex4_3.core;

import MVVM.Ex4_3.model.TextConverter;
import MVVM.Ex4_3.model.TextConverterModel;

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
