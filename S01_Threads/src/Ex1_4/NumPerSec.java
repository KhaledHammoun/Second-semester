package Ex1_4;

public class NumPerSec implements Runnable
{
  private int number;

  public NumPerSec(int number)
  {
    this.number = number;
  }

  public void run()
  {
    for (int i = 0; i < number; i++)
    {
      try
      {
        Thread.sleep(1000);
      }
      catch (InterruptedException e)
      {
        System.out.println("I was interrupted!");
      }
      System.out.println(i);
    }
  }
}
