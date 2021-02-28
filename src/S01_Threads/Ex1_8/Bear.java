package S01_Threads.Ex1_8;

import java.util.ArrayList;

public class Bear implements Runnable
{
  private ArrayList<Thread> bears;

  public Bear(ArrayList<Thread> bears)
  {
    this.bears = bears;
  }

  public Bear()
  {
    bears = null;
  }
  
  @Override public void run()
  {
    try
    {
      Thread.sleep(10000);
      System.out.println("Happy!");
    }
    catch (InterruptedException e)
    {
      for (Thread bear: bears )
      {
        bear.interrupt();
      }
      System.out.println("Angry");
    }
  }
}
