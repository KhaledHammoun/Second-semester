package Ex4_3.model;

import java.util.ArrayList;

public interface TextConverter
{
  public String toUppercase(String text);
  public void addLog(String log);
  public ArrayList<String> getLogs();
}
