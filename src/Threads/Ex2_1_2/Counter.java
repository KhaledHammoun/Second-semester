package Threads.Ex2_1_2;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Counter
{
  private int counter;
  private int counterTwo;

  private Lock lock;
  private Lock lockTwo;

  public Counter()
  {
    counter = 0;
    counterTwo = 0;
    lock = new ReentrantLock();
    lockTwo = new ReentrantLock();
  }

  public void incrementCounter()
  {
    //counter++;
    synchronized (lock)
    {
      counter++;
    }
  }

  public void incrementCounterTwo()
  {
    synchronized (lockTwo)
    {
      counterTwo++;
    }
  }

  public int getCounter()
  {
    synchronized (lock)
    {
      return counter;
    }
  }

  public int getCounterTwo()
  {
    synchronized (lockTwo)
    {
      return counterTwo;
    }
  }
}
