package Ex2_4;

public class CounterIncrement implements Runnable
{
  private Counter counter;
  private int updates;

  public CounterIncrement(Counter counter, int updates)
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
    System.out.println(
        Thread.currentThread().getName() + " is done incrementing with value: "
            + counter.getValue());
  }
}
