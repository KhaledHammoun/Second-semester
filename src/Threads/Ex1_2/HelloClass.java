package Threads.Ex1_2;

public class HelloClass implements Runnable
{
  public void run()
  {
    for (int i = 0; i < 1000; i++)
    {
      System.out.println("Hello");
    }
  }
}
