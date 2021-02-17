package Threads.Ex2_6;

import java.util.ArrayList;

public class Bar implements Runnable
{
  private ArrayList<Beer> beers;
  private final int BEERS_ALLOWED = 20;
  private long closingTime;
  private boolean isOpen;

  public Bar(long closingTime)
  {
    beers = new ArrayList<>();
    isOpen = true;
    this.closingTime = closingTime;
  }

  public synchronized void placeBeer(Beer b)
  {

    while (beers.size() >= 20)
    {
      try
      {
        wait();
      }
      catch (InterruptedException e)
      {

      }
    }
    if (isOpen)
    {
      beers.add(b);
      System.out.println(Thread.currentThread().getName() + " places a beer.");
    }
    notifyAll();
  }

  public synchronized void takeBeer()
  {
    while (beers.size() <= 0)
    {
      try
      {
        wait();
      }
      catch (InterruptedException e)
      {

      }
    }
    if (isOpen)
    {
      beers.remove(0);
      System.out.println(Thread.currentThread().getName() + " takes a beer.");
    }
    notifyAll();
  }

  public void run()
  {
    try
    {
      Thread.sleep(closingTime);
    }
    catch (InterruptedException e)
    {

    }
    isOpen = false;
    System.out.println("The bar is closed!");
    System.out.println(beers.size() + " beers left.");
  }

  public synchronized boolean isOpen()
  {
    return isOpen;
  }
}
