package Ex2_2;

public class Start
{
  public static void main(String[] args)
  {
    ListContainer integers = new ListContainer();
    Thread firstListThread = new Thread(new ContainerFiller(integers));
    Thread secondListThread = new Thread(new ContainerFiller(integers));

    firstListThread.start();
    secondListThread.start();
  }
}
