package Threads;

import org.w3c.dom.css.Counter;

import java.util.ArrayList;

public class Start
{
  public static void main(String[] args)
  {
    //    // Exercise 1.1. The 2 classes have a Thread.sleep for 1sec after each iteration of the loop.
    //    Thread firstThread = new Thread(new Numbers(57));
    //    Thread secondThread = new Thread(new Letters(33));
    //
    //    firstThread.start();
    //    secondThread.start();
    //
    //    // Exercise 1.2
    //    Thread thirdThread = new Thread(new HiClass());
    //    Thread fourthThread = new Thread(new HelloClass());
    //
    //    thirdThread.start();
    //    fourthThread.start();
    //
    //    // Exercise 1.3. In this example we use the run method from the classes. The the treads
    //    // do not alternate between each other.
    //    HiClass hi = new HiClass();
    //    HelloClass hello = new HelloClass();
    //
    //    hi.run();
    //    hello.run();
    //
    //    Thread fifthThread = new Thread(new NumPerSec(11));
    //
    //    fifthThread.start();
    //
    //    //Exercise 1.4
    //    new Thread(() -> {
    //      for (int i = 0; i < 10; i++)
    //      {
    //        try
    //        {
    //          Thread.sleep(1000);
    //        }
    //        catch (InterruptedException e)
    //        {
    //          System.out.println("I was interrupted!");
    //        }
    //        System.out.println(i);
    //      }
    //    }).start();
    //
    //    // Exercise 1.5
    //    Thread sixthThread = new Thread(new JoiningThreads(0, 25000));
    //    Thread seventhThread = new Thread(
    //        new JoiningThreads(25000, 50000, sixthThread));
    //    Thread eightThread = new Thread(
    //        new JoiningThreads(50000, 75000, seventhThread));
    //
    //    sixthThread.start();
    //    seventhThread.start();
    //    eightThread.start();
    //
    //    // Exercise 1.6
    //    Thread bearThread = new Thread(new Bear());
    //    Thread pokingMan = new Thread(new PokingMan(bearThread));
    //
    //    bearThread.start();
    //    pokingMan.start();
    //
    //    //Exercise 1.7
    //    Counter count = new Counter();
    //    Thread incrementerOne = new Thread(new CounterIncrementer(count));
    //    Thread incrementerTwo = new Thread(new CounterIncrementer(count));
    //
    //    incrementerOne.start();
    //    incrementerTwo.start();
    //
    //    try
    //    {
    //      Thread.sleep(2000);
    //    }
    //    catch (InterruptedException e)
    //    {
    //      System.out.println("Was interrupted!");
    //    }
    //    System.out.println(count.getCounter());
    //
    //    // Exercise 1.8
    //    ArrayList<Thread> bears = new ArrayList<>();
    //
    //    Thread firstBear = new Thread(new Bear(bears));
    //    Thread secondBear = new Thread(new Bear(bears));
    //    Thread thirdBear = new Thread(new Bear(bears));
    //    Thread fourthBear = new Thread(new Bear(bears));
    //    Thread fifthBear = new Thread(new Bear(bears));
    //
    //    bears.add(firstBear);
    //    bears.add(secondBear);
    //    bears.add(thirdBear);
    //    bears.add(fourthBear);
    //    bears.add(fifthBear);
    //
    //    firstBear.start();
    //    secondBear.start();
    //    thirdBear.start();
    //    fourthBear.start();
    //    fifthBear.start();
    //
    //    Thread pokeMan = new Thread(new PokingMan(firstBear));
    //
    //    pokeMan.start();
    //
    //    //Exercise 1.9
    //    Turtle turtle = new Turtle();
    //    Thread turtleThread = new Thread(turtle);
    //    Thread rabbit = new Thread(new Rabbit(turtle));
    //
    //    turtleThread.start();
    //    rabbit.start();
    //
    //    // Exercise 2.1.1
    //    Counter counter = new Counter();
    //    Thread firstIncrementer = new Thread(new CounterIncrementer(counter));
    //    Thread secondIncrementer = new Thread(new CounterIncrementer(counter));
    //
    //    firstIncrementer.start();
    //    secondIncrementer.start();

    //    // Exercise 2.1.2
    //    Counter first = new Counter();
    //    Thread counterA = new Thread(new CounterIncrementer(first));
    //    Thread counterB = new Thread(new CounterIncrementer(first));
    //
    //    counterA.start();
    //    counterB.start();

    //    // Exercise 2.1.3
    //     CounterTryLock counter = new CounterTryLock();
    //     Thread counterOne = new Thread(new CounterIncrementTryLock(counter));
    //     Thread counterTwo = new Thread(new CounterIncrementTryLock(counter));
    //
    //     counterOne.start();
    //     counterTwo.start();

    //    // Exercise 2.2
    //    ListContainer integers = new ListContainer();
    //    Thread firstListThread = new Thread(new ContainerFiller(integers));
    //    Thread secondListThread = new Thread(new ContainerFiller(integers));
    //
    //    firstListThread.start();
    //    secondListThread.start();

    //    // Exercise 2.3
    //    Thermometer thermometer = new Thermometer("t1", 15);
    //    Thread thermometerThread = new Thread(thermometer);
    //
    //    thermometerThread.start();

    //    // Exercise 2.3.1
    //    Thermometer thermometerOne = new Thermometer("t1", 15, 1);
    //    Thermometer thermometerTwo = new Thermometer("t2", 15, 7);
    //
    //    Thread thermometerOneThread = new Thread(thermometerOne);
    //    Thread thermometerTwoThread = new Thread(thermometerTwo);
    //
    //    thermometerOneThread.start();
    //    thermometerTwoThread.start();

    //    // Todo Only incrementing. Exercise 2.4	Increment/decrement
    //    CounterIncDec counterIncDec = new CounterIncDec(-50, 50);
    //
    //    CounterIncrementerDec firstIncrementer = new CounterIncrementerDec(
    //        counterIncDec, 400);
    //    CounterIncrementerDec secondIncrementer = new CounterIncrementerDec(
    //        counterIncDec, 400);
    //
    //    CounterDecrementerInc firstDecrement = new CounterDecrementerInc(
    //        counterIncDec, 400);
    //    CounterDecrementerInc secondDecrement = new CounterDecrementerInc(
    //        counterIncDec, 400);
    //
    //    Thread firstThread = new Thread(firstIncrementer);
    //    Thread secondThread = new Thread(secondIncrementer);
    //    Thread thirdThread = new Thread(firstDecrement);
    //    Thread fourthThread = new Thread(secondDecrement);
    //
    //    firstThread.setName("firstIncrementer");
    //    secondThread.setName("secondIncrementer");
    //    thirdThread.setName("firstDecrement");
    //    fourthThread.setName("secondDecrement");
    //
    //    firstThread.start();
    //    secondThread.start();
    //    thirdThread.start();
    //    fourthThread.start();

    //    // Exercise 2.5	Computer simulation
    //    Thread mailbox = new Thread(new Mailbox(20));
    //    Thread program1 = new Thread(new Program("Windows", "update", 30));
    //    Thread program2 = new Thread(
    //        new Program("AVG", "update virus database", 5));
    //    Thread program3 = new Thread(
    //        new Program("FBackup", "perform a scheduled backup", 3));
    //    Thread program4 = new Thread(
    //        new Program("Skype", "notify you about a person logging in", 17));
    //
    //    System.out.println("---->Turning on the computer");
    //
    //    program1.start();
    //    program2.start();
    //    program3.start();
    //    program4.start();
    //    mailbox.start();

    // Exercise 2.6	Bar
    Bar bar = new Bar(20000);

    Customer firstCustomer = new Customer(bar);
    Customer secondCustomer = new Customer(bar);
    Customer thirdCustomer = new Customer(bar);
    Customer fourthCustomer = new Customer(bar);
    Customer fifthCustomer = new Customer(bar);
    Customer sixthCustomer = new Customer(bar);
    Customer seventhCustomer = new Customer(bar);
    Customer eightCustomer = new Customer(bar);

    Bartender firstBartender = new Bartender(bar);
    Bartender secondBartender = new Bartender(bar);

    Thread firstThread = new Thread(fifthCustomer);
    Thread secondThread = new Thread(secondCustomer);
    Thread thirdThread = new Thread(thirdCustomer);
    Thread fourthThread = new Thread(fourthCustomer);
    Thread fifthThread = new Thread(fifthCustomer);
    Thread sixthThread = new Thread(sixthCustomer);
    Thread seventhThread = new Thread(seventhCustomer);
    Thread eightThread = new Thread(eightCustomer);
    Thread ninthThread = new Thread(firstBartender);
    Thread tenthThread = new Thread(secondBartender);
    Thread eleventhThread = new Thread(bar);

    firstThread.setName("Fifth Customer");
    secondThread.setName("Second Customer");
    thirdThread.setName("Third Customer");
    fourthThread.setName("Fourth Customer");
    fifthThread.setName("Fifth Customer");
    sixthThread.setName("Sixth Customer");
    seventhThread.setName("Seventh Customer");
    eightThread.setName("Eight Customer");
    ninthThread.setName("First Bartender");
    tenthThread.setName("Second Bartender");
    eleventhThread.setName("The bar");

    firstThread.start();
    secondThread.start();
    thirdThread.start();
    fourthThread.start();
    fifthThread.start();
    sixthThread.start();
    seventhThread.start();
    eightThread.start();
    ninthThread.start();
    tenthThread.start();
    eleventhThread.start();
  }
}
