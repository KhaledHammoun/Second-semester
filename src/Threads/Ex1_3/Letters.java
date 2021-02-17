package Threads.Ex1_3;

public class Letters implements Runnable
{

  private int numberOfIterations;

  public Letters(int num)
  {
    numberOfIterations = num;
  }

  @Override public void run()
  {
    while (true)
    {
      for (int i = 0; i < numberOfIterations; i++)
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
