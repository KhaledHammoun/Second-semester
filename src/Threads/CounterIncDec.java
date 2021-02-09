package Threads;

import javax.swing.plaf.IconUIResource;

public class CounterIncDec
{
  private long value, max, min;

  public CounterIncDec(long min, long max)
  {
    value = 0;
    this.min = min;
    this.max = max;
  }

  public synchronized void increment()
  {
    while (value >= max)
    {
      try
      {
        wait();
        System.out.println(Thread.currentThread().getName() + " waiting to increment.");
      }
      catch (InterruptedException e)
      {

      }
    }
    value++;
    System.out.println(value + ": " + Thread.currentThread().getName());
    notifyAll();
  }

  public synchronized void decrement()
  {
    while (value <= min)
    {
      try
      {
        wait();
        System.out.println(Thread.currentThread().getName() + " waiting to decrement.");

      }
      catch (InterruptedException e)
      {

      }
      value--;
      System.out.println(value + ": " + Thread.currentThread().getName());
      notifyAll();
    }
  }

  public synchronized long getValue()
  {
    return value;
  }
}
