package Threads.Ex1_5;

public class Start
{
  public static void main(String[] args)
  {
    Thread sixthThread = new Thread(new JoiningThreads(0, 25000));
    Thread seventhThread = new Thread(
        new JoiningThreads(25000, 50000, sixthThread));
    Thread eightThread = new Thread(
        new JoiningThreads(50000, 75000, seventhThread));

    sixthThread.start();
    seventhThread.start();
    eightThread.start();
  }
}
