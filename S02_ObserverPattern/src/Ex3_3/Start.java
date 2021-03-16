package Ex3_3;

public class Start
{
  public static void main(String[] args)
  {
    WaitingRoom waitingRoom = new WaitingRoom();
    for (int i = 0; i < 10; i++)
    {
      new Patient(i, waitingRoom);
    }

    waitingRoom.start();
  }
}
