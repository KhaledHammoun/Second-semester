package Threads.Ex1_1;

public class Numbers implements Runnable
{
  public void run()
  {
    while (true)
    {
      for (int i = 0; i < 10; i++)
      {
        System.out.println(i);
        try
        {
          Thread.sleep(1000);
        }
        catch (InterruptedException e)
        {
          System.out.println("I woke up");
        }
      }

    }
  }
}
