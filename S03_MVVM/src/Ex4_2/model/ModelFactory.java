package Ex4_2.model;

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
