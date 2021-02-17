package Threads.Ex1_1;

public class Start
{
  public static void main(String[] args)
  {
    Thread firstThread = new Thread(new Numbers());
    Thread secondThread = new Thread(new Letters());

    firstThread.start();
    secondThread.start();
  }
}
