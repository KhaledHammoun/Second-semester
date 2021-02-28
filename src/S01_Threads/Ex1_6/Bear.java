package S01_Threads.Ex1_6;

public class Bear implements Runnable
{
  @Override public void run()
  {
    try
    {
      Thread.sleep(10000);
      System.out.println("Happy!");
    }
    catch (InterruptedException e)
    {
      System.out.println("Angry");
    }
  }
}
