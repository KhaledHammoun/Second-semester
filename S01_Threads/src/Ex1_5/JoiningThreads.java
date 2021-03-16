package Ex1_5;

public class JoiningThreads implements Runnable
{
  private int startNum;
  private int endNum;
  private Thread threadToJoin;

  public JoiningThreads(int startNum, int endNum, Thread threadToJoin)
  {
    this.startNum = startNum;
    this.endNum = endNum;
    this.threadToJoin = threadToJoin;
  }

  public JoiningThreads(int startNum, int endNum)
  {
    this.startNum = startNum;
    this.endNum = endNum;
  }

  public void run()
  {
    try
    {
      if (threadToJoin != null)
      {
        threadToJoin.join();
      }
    }
    catch (InterruptedException e)
    {
      System.out.println("I was interrupted!");
    }

    for (int i = startNum; i < endNum; i++)
    {
      System.out.println(i);
    }
  }
}
