package S01_Threads.Ex1_1;

public class Letters implements Runnable
{
  @Override public void run()
  {
    while (true)
    {
      for (int i = 0; i < 10; i++)
      {
        System.out.println((char)(97+i));
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
