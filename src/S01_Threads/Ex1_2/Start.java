package S01_Threads.Ex1_2;

public class Start
{
  public static void main(String[] args)
  {
    Thread thirdThread = new Thread(new HiClass());
    Thread fourthThread = new Thread(new HelloClass());

    thirdThread.start();
    fourthThread.start();

    // In this example we use the run method from the classes. The the treads
    // do not alternate between each other.
    HiClass hi = new HiClass();
    HelloClass hello = new HelloClass();

    hi.run();
    hello.run();
  }
}
