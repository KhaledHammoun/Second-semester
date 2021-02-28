package S01_Threads.Ex1_6;

public class Start
{
  public static void main(String[] args)
  {
    Thread bearThread = new Thread(new Bear());
    Thread pokingMan = new Thread(new PokingMan(bearThread));

    bearThread.start();
    pokingMan.start();
  }
}
