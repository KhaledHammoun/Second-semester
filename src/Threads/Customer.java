package Threads;

import java.util.Random;

public class Customer implements Runnable
{
  private Bar bar;
  private Random rnd;

  public Customer(Bar bar)
  {
    this.bar = bar;
    rnd = new Random();
  }

  @Override public void run()
  {
    while (bar.isOpen())
    {
      int rndNum = rnd.nextInt(10000) +5000;
      try
      {
        Thread.sleep(rndNum);
      }
      catch (InterruptedException | IllegalMonitorStateException e)
      {

      }
      bar.takeBeer();
    }
  }
}
