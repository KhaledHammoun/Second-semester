package S06_Sockets.Ex11_6.Server;

public class Counter
{
  private int counter;

  public Counter()
  {
    counter = 0;
  }

  public synchronized void increment()
  {
    counter++;
  }

  public synchronized int getCounter()
  {
    return counter;
  }
}
