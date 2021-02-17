package Threads.Ex2_1_3;

public class CounterIncrement implements Runnable
{
  private Counter counter;

  public CounterIncrement(Counter counter)
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
