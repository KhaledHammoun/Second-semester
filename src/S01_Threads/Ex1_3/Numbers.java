package S01_Threads.Ex1_3;

public class Numbers implements Runnable
{
  private int numberOfIterations;

  public Numbers(int num)
  {
    numberOfIterations = num;
  }

  public void run()
  {
    while (true)
    {
      for (int i = 0; i < numberOfIterations; i++)
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
