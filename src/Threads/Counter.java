package Threads;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Counter
{
  private int counter;
  private Lock lock;

  public Counter()
  {
    counter = 0;
    lock = new ReentrantLock();
  }

  public synchronized void incrementCount()
  {
    //counter++;
    synchronized (lock)
    {
      counter++;
    }
  }

  public int getCounter()
  {
    return counter;
  }
}
