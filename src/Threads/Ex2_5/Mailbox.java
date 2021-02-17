package Threads.Ex2_5;

import java.util.Random;

public class Mailbox implements Runnable
{
  private int count;
  private final long RUNTIME = 100000;
  private Random rnd;

  public Mailbox(int count)
  {
    this.count = count;
    rnd = new Random();
  }

  @Override public void run()
  {
    for (int i = 0; i < count; i++)
    {
      int rndNum = rnd.nextInt(29)+1;
      System.out.println("New mail in your mailbox...");
      try
      {
        Thread.sleep(RUNTIME / rndNum);
      }
      catch (InterruptedException e)
      {
        System.out.println("Mailbox was interrupted.");
      }
    }
  }
}
