package Threads;

public class CounterIncrementer implements Runnable
{
  private Counter counter;

  public CounterIncrementer(Counter counter)
  {
    this.counter = counter;
  }

  public void run()
  {
    for (int i = 0; i < 1000000; i++)
    {
      counter.incrementCount();
    }

    int num = counter.getCounter();
    System.out.println(num);
  }
}
