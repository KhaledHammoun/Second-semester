package Threads;

public class CounterDecrementerInc implements Runnable
{
  private CounterIncDec counter;
  private int updates;

  public CounterDecrementerInc(CounterIncDec counter, int updates)
  {
    this.counter = counter;
    this.updates = updates;
  }

  @Override public void run()
  {
    for (int i = 0; i < updates; i++)
    {
      counter.decrement();
    }
    System.out.println(counter.getValue());
  }
}
