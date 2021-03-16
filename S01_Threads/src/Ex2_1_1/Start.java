package Ex2_1_1;

public class Start
{
  public static void main(String[] args)
  {
    Counter counter = new Counter();
    Thread firstIncrementer = new Thread(new CounterIncrementer(counter));
    Thread secondIncrementer = new Thread(new CounterIncrementer(counter));

    firstIncrementer.start();
    secondIncrementer.start();

  }
}
