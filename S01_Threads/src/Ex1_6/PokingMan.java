package Ex1_6;

public class PokingMan implements Runnable
{
  private Thread bearThread;

  public PokingMan(Thread bearThread)
  {
    this.bearThread  = bearThread;
  }

  public void run()
  {
    bearThread.interrupt();
  }
}
