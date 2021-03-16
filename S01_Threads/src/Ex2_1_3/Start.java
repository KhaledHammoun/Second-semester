package Ex2_1_3;

public class Start
{
  public static void main(String[] args)
  {
    Counter counter = new Counter();
    Thread counterOne = new Thread(new CounterIncrement(counter));
    Thread counterTwo = new Thread(new CounterIncrement(counter));

    counterOne.start();
    counterTwo.start();
    try
    {
      Thread.sleep(5000);
    }
    catch (InterruptedException e)
    {

    }
    System.out.println("Counter " + counter.getCounter());
  }
}
