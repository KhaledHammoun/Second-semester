package Ex2_2;

import java.util.ArrayList;

public class ListContainer
{
  private ArrayList<Integer> integers;

  public ListContainer()
  {
    integers = new ArrayList<>();
  }

  public void add(int i)
  {
    synchronized (this)
    {
      integers.add(i);
    }
  }

  public synchronized int size()
  {
    return integers.size();
  }
}
