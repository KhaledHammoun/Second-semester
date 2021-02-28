package S01_Threads.Ex2_4;

import java.util.ArrayList;

public class Joiner implements Runnable
{
  private Counter counter;
  private ArrayList<Thread> threads;
  public Joiner(Counter counter, ArrayList<Thread> threads)
  {
    this.counter = counter;
    this.threads = threads;

  }

  @Override public void run()
  {
    try
    {
      for (Thread thread : threads)
      {
        thread.join();
      }
    }
    catch (InterruptedException e)
    {

    }
    System.out.println("Final value: " + counter.getValue());
  }
}
