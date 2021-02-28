package S03_MVVM.Ex4_2.model;

public class TextConverterModel implements TextConverter
{
  public TextConverterModel()
  {

  }

  @Override public String toUppercase(String text)
  {
    return text.toUpperCase();
  }
}
