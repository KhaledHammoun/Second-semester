package Threads.Ex2_4;

import java.lang.module.InvalidModuleDescriptorException;

public class Counter
{
  private long value, max, min;

  public Counter(long min, long max)
  {
    value = 0;
    this.min = min;
    this.max = max;
  }

  public synchronized void increment()
  {
    if (value >= max)
    {
      try
      {
        System.out.println(Thread.currentThread().getName() + " waiting to increment.");
        wait(1000);
      }
      catch (InterruptedException | IllegalMonitorStateException e)
      {

      }
    }
    else
    {
      value++;
      System.out.println(value + ": " + Thread.currentThread().getName());
    }
    notifyAll();
  }

  public synchronized void decrement()
  {
    if (value <= min)
    {
      try
      {
        System.out.println(Thread.currentThread().getName() + " waiting to decrement.");
        wait(1000);
      }
      catch (InterruptedException | IllegalMonitorStateException e)
      {

      }
    }
    else
    {
      value--;
      System.out.println(value + ": " + Thread.currentThread().getName());
    }
      notifyAll();
  }

  public synchronized long getValue()
  {
    return value;
  }
}
