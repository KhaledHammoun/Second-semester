package Threads.Ex2_1_2;

import Threads.Ex2_1_1.Counter;
import Threads.Ex2_1_1.CounterIncrementer;

public class Start
{
  public static void main(String[] args)
  {
    Counter counterA = new Counter();
    Counter counterB = new Counter();

    Thread firstIncrementer = new Thread(new CounterIncrementer(counterA));
    Thread secondIncrementer = new Thread(new CounterIncrementer(counterA));
    Thread thirdIncrementer = new Thread(new CounterIncrementer(counterB));
    Thread fourthIncrementer = new Thread(new CounterIncrementer(counterB));

    firstIncrementer.start();
    secondIncrementer.start();
    thirdIncrementer.start();
    fourthIncrementer.start();
  }
}
