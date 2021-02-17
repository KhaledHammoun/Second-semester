package Threads.Ex2_6;

public class Bartender implements Runnable
{
  private Bar bar;

  public Bartender(Bar bar)
  {
    this.bar = bar;
  }

  @Override public void run()
  {
    while (bar.isOpen())
    {
      try
      {
        Thread.sleep(2000);
      }
      catch (InterruptedException e)
      {

      }
      bar.placeBeer(new Beer());
    }
  }
}
