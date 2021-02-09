package Threads;

import java.util.ArrayList;

public class Start
{
  public static void main(String[] args)
  {
    // Exercise 1.1. The 2 classes have a Thread.sleep for 1sec after each iteration of the loop.
    Thread firstThread = new Thread(new Numbers(57));
    Thread secondThread = new Thread(new Letters(33));

    firstThread.start();
    secondThread.start();

    // Exercise 1.2
    Thread thirdThread = new Thread(new HiClass());
    Thread fourthThread = new Thread(new HelloClass());

    thirdThread.start();
    fourthThread.start();

    // Exercise 1.3. In this example we use the run method from the classes. The the treads
    // do not alternate between each other.
    HiClass hi = new HiClass();
    HelloClass hello = new HelloClass();

    hi.run();
    hello.run();

    Thread fifthThread = new Thread(new NumPerSec(11));

    fifthThread.start();

    //Exercise 1.4
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

    // Exercise 1.5
    Thread sixthThread = new Thread(new JoiningThreads(0, 25000));
    Thread seventhThread = new Thread(
        new JoiningThreads(25000, 50000, sixthThread));
    Thread eightThread = new Thread(
        new JoiningThreads(50000, 75000, seventhThread));

    sixthThread.start();
    seventhThread.start();
    eightThread.start();

    // Exercise 1.6
    Thread bearThread = new Thread(new Bear());
    Thread pokingMan = new Thread(new PokingMan(bearThread));

    bearThread.start();
    pokingMan.start();

    //Exercise 1.7
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

    // Exercise 1.8
    ArrayList<Thread> bears = new ArrayList<>();

    Thread firstBear = new Thread(new Bear(bears));
    Thread secondBear = new Thread(new Bear(bears));
    Thread thirdBear = new Thread(new Bear(bears));
    Thread fourthBear = new Thread(new Bear(bears));
    Thread fifthBear = new Thread(new Bear(bears));

    bears.add(firstBear);
    bears.add(secondBear);
    bears.add(thirdBear);
    bears.add(fourthBear);
    bears.add(fifthBear);

    firstBear.start();
    secondBear.start();
    thirdBear.start();
    fourthBear.start();
    fifthBear.start();

    Thread pokeMan = new Thread(new PokingMan(firstBear));

    pokeMan.start();

    //Exercise 1.9
    Turtle turtle = new Turtle();
    Thread turtleThread = new Thread(turtle);
    Thread rabbit = new Thread(new Rabbit(turtle));

    turtleThread.start();
    rabbit.start();

    // Exercise 2.1.1 and 2.1.2
    Counter counter = new Counter();
    Thread firstIncrementer = new Thread(new CounterIncrementer(counter));
    Thread secondIncrementer = new Thread(new CounterIncrementer(counter));

    firstIncrementer.start();
    secondIncrementer.start();
  }
}
