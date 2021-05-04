package actors;

import multiton.MinedValuable;
import singleton.Logger;
import treasuries.Guardsman;
import treasuries.TreasureRoomDoor;

import java.util.ArrayList;
import java.util.Random;

public class King implements Runnable
{
    private ArrayList<MinedValuable> valuablesToSpend;
    private TreasureRoomDoor treasure;
    private Random rnd;

    public King()
    {
        valuablesToSpend = new ArrayList<>();
        this.treasure = Guardsman.getInstance();
        rnd = new Random();
    }

    @Override
    public void run()
    {
        while (true)
        {
            int partyMoneyNeeded = 50 + rnd.nextInt(100);
            double actualMoneyAcquired = 0;
            treasure.acquireWrite(this);

            while (partyMoneyNeeded > actualMoneyAcquired)
            {
                MinedValuable toSpend = treasure.spendValuable();
                if (toSpend == null)
                    break;
                actualMoneyAcquired += toSpend.getValue();
                valuablesToSpend.add(toSpend);
                sleep(100, 100);
            }

            if (partyMoneyNeeded > actualMoneyAcquired)
            {
                Logger.getInstance().log("King is angry. Everyone get beheaded.");
                if (valuablesToSpend.size() != 0)
                    treasure.addValuables(valuablesToSpend);
            }
            else
            {
                Logger.getInstance().log("Dance barty barty. BUmci Bumci!");
                valuablesToSpend.clear();
            }

            treasure.releaseWrite();
            sleep(5000, 2000);
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
