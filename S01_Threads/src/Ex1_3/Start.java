package Ex1_3;

public class Start
{
  public static void main(String[] args)
  {
    Thread firstThread = new Thread(new Numbers(57));
    Thread secondThread = new Thread(new Letters(33));

    firstThread.start();
    secondThread.start();
  }
}
