package Threads;

import java.util.ArrayList;

public class ContainerFiller implements Runnable
{
  private ListContainer integers;

  public ContainerFiller(ListContainer integers)
  {
    this.integers = integers;
  }

  public void run()
  {
    for (int i = 0; i < 100000; i++)
    {
      integers.add(i);
    }

    System.out.println(integers.size());
  }
}
