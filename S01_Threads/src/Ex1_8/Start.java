package Ex1_8;

import java.util.ArrayList;

public class Start
{
  public static void main(String[] args)
  {

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

  }
}
