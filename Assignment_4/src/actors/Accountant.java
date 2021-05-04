package actors;

import singleton.Logger;
import treasuries.Guardsman;
import treasuries.TreasureRoomDoor;

import java.util.Random;

public class Accountant implements Runnable
{
    private TreasureRoomDoor treasure;
    private Random rnd;

    public Accountant()
    {
        this.treasure = Guardsman.getInstance();
        rnd = new Random();
    }

    @Override
    public void run()
    {
        while (true)
        {
            treasure.acquireRead(this);
            double total = treasure.countValuable();

            sleep(500,500);

            Logger.getInstance().log("The accountant counted " + total);
            treasure.releaseRead();

            sleep(5000,1000);
        }
    }

    private void sleep(int from, int to)
    {
        try
        {
            Thread.sleep(from + rnd.nextInt(to));
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }
}
