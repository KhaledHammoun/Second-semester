package Threads;

public class Turtle implements Runnable
{
  private int metersRun;

  public Turtle()
  {
    metersRun = 0;
  }
  public void advance()
  {
    metersRun++;
  }

  public int getMetersRun()
  {
    return metersRun;
  }

  @Override public void run()
  {
    for (int i = 0; i < 1000; i++)
    {
      try
      {
        Thread.sleep(10);
      }
      catch (InterruptedException e)
      {
        System.out.println("I was interrupted");
      }
      advance();
    }
    System.out.println("Turtle: " + metersRun);
  }
}
