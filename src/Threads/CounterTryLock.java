package Threads;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class CounterTryLock
{
  private int counter;
  private Lock lock;

  public CounterTryLock()
  {
    counter = 0;
    lock = new ReentrantLock();
  }

  public int getCounter()
  {
    while (!lock.tryLock())
    {
      try
      {
        wait(1);
      }
      catch (InterruptedException | IllegalMonitorStateException e)
      {

      }
    }
    lock.unlock();
    return counter;
  }

  public void increment()
  {
    while (!lock.tryLock())
    {
      try
      {
        wait(10000);
      }
      catch (InterruptedException | IllegalMonitorStateException e)
      {

      }
    }
    counter++;
    lock.unlock();
  }
}
