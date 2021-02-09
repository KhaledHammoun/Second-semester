package Threads;

import java.util.Random;

public class Rabbit implements Runnable
{
  private int metersRun;
  private Turtle turtle;

  public Rabbit(Turtle turtle)
  {
    this.metersRun = 0;
    this.turtle = turtle;
  }

  public void run()
  {
    Random rnd = new Random();
    int sleepingTime = rnd.nextInt(500) + 500;

    while (metersRun < 1000 && turtle.getMetersRun() < 1000)
    {
      if (metersRun - turtle.getMetersRun() < 50)
      {
        metersRun++;
      }
      else
      {
        try
        {
          Thread.sleep(sleepingTime);
        }
        catch (InterruptedException e)
        {
          System.out.println("I was interrupted!");
        }
      }
    }
    System.out.println("Rabbit: " + metersRun);
  }
}
