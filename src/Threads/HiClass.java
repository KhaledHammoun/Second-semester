package Threads;

public class HiClass implements Runnable
{
  public void run()
  {
    for (int i = 0; i < 1000; i++)
    {
      System.out.println("hi");
    }
  }
}
