package Threads;

public class CounterIncrementTryLock implements Runnable
{
  private CounterTryLock counter;

  public CounterIncrementTryLock(CounterTryLock counter)
  {
    this.counter = counter;
  }

  public void run()
  {
    for (int i = 0; i < 2000000; i++)
    {
      counter.increment();
    }
    System.out.println(counter.getCounter());
  }
}
