package Threads;

import java.util.Random;

public class Program implements Runnable
{
  private String program, action;
  private int count;
  private final long RUNTIME = 100000;
  private Random rnd;

  public Program(String program, String action, int count)
  {
    this.program = program;
    this.action = action;
    this.count = count;
    rnd = new Random();
  }

  public void run()
  {
    for (int i = 0; i < count; i++)
    {
      int rndNUm = rnd.nextInt(29)+1;
      try
      {
        Thread.sleep(RUNTIME/rndNUm);
      }
      catch (InterruptedException e)
      {

      }
      System.out.println(program+ " wants to " + action);
    }
  }
}
