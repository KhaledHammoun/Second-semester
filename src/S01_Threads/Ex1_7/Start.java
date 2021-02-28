package S01_Threads.Ex1_7;

public class Start
{
  public static void main(String[] args)
  {
    Counter count = new Counter();
    Thread incrementerOne = new Thread(new CounterIncrementer(count));
    Thread incrementerTwo = new Thread(new CounterIncrementer(count));

    incrementerOne.start();
    incrementerTwo.start();

    try
    {
      Thread.sleep(2000);
    }
    catch (InterruptedException e)
    {
      System.out.println("Was interrupted!");
    }
    System.out.println(count.getCounter());

  }
}
