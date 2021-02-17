package Threads.Ex1_4;

public class Start
{
  public static void main(String[] args)
  {
    Thread fifthThread = new Thread(new NumPerSec(11));

    fifthThread.start();
    /*
    new Thread(() -> {
      for (int i = 0; i < 10; i++)
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
    }).start();
*/
  }
}
