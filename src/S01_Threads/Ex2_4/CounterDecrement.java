package S01_Threads.Ex2_4;

public class CounterDecrement implements Runnable
{
  private Counter counter;
  private int updates;

  public CounterDecrement(Counter counter, int updates)
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
    System.out.println(
        Thread.currentThread().getName() + " is done decrementing with value: "
            + counter.getValue());

  }
}
