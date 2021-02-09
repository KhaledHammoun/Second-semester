package Threads;

public class CounterIncrementerDec implements Runnable
{
  private CounterIncDec counter;
  private int updates;

  public CounterIncrementerDec(CounterIncDec counter, int updates)
  {
    this.counter = counter;
    this.updates = updates;
  }

  @Override public void run()
  {
    for (int i = 0; i < updates; i++)
    {
      counter.increment();
    }
    System.out.println(counter.getValue());
  }
}
