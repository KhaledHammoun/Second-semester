package Threads.Ex2_1_1;

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
      counter.incrementCounter();
    }

    for (int i = 0; i < 1000000; i++)
    {
      counter.incrementCounterTwo();
    }

    int num = counter.getCounter();
    System.out.println(num);
    System.out.println(counter.getCounterTwo());
  }
}
