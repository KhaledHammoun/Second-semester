package S03_MVVM.Ex4_3.model;

import java.util.ArrayList;

public class TextConverterModel implements TextConverter
{
  private ArrayList<String> logs;

  public TextConverterModel()
  {
    logs = new ArrayList<>();
  }

  public ArrayList<String> getLogs()
  {
    return logs;
  }

  public int getNumberOfLogs()
  {
    return logs.size();
  }

  @Override public String toUppercase(String text)
  {
    addLog(text);
    return text.toUpperCase();
  }

  @Override public void addLog(String log)
  {
    logs.add(log);
  }
}
