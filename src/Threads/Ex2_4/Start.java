package Threads.Ex2_4;

import java.util.ArrayList;

public class Start
{
  public static void main(String[] args)
  {
    Counter counter = new Counter(0, 19);

    CounterIncrement firstIncrementer = new CounterIncrement(counter, 200);
    CounterIncrement secondIncrementer = new CounterIncrement(counter, 200);

    CounterDecrement firstDecrement = new CounterDecrement(counter, 200);
    CounterDecrement secondDecrement = new CounterDecrement(counter, 200);
    Thread firstThread = new Thread(firstIncrementer);
    Thread secondThread = new Thread(secondIncrementer);
    Thread thirdThread = new Thread(firstDecrement);
    Thread fourthThread = new Thread(secondDecrement);

    ArrayList<Thread> threads = new ArrayList<>();
    threads.add(firstThread);
    threads.add(secondThread);
    threads.add(thirdThread);
    threads.add(fourthThread);

    Joiner joiner = new Joiner(counter, threads);
    Thread fifthThread = new Thread(joiner);

    firstThread.setName("firstIncrementer");
    secondThread.setName("secondIncrementer");
    thirdThread.setName("firstDecrement");
    fourthThread.setName("secondDecrement");

    thirdThread.start();
    fourthThread.start();
    firstThread.start();
    secondThread.start();
    fifthThread.start();
  }
}
