package actors;

import multiton.MinedValuable;
import singleton.Logger;
import treasuties.Guardsman;
import treasuties.TreasureRoomDoor;

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
            int partyMoney = 50 + rnd.nextInt(100);
            double actualMoney = 0;
            treasure.acquireWrite(this);

            while (partyMoney < actualMoney)
            {
                MinedValuable toSpend = treasure.spendValuable();
                if (toSpend == null)
                    break;
                actualMoney += toSpend.getValue();
                valuablesToSpend.add(toSpend);
                sleep(100, 100);
            }

            if (partyMoney < actualMoney)
            {
                Logger.getInstance().log("King is angry. Everyone get beheaded.");
                treasure.addValuable(valuablesToSpend);
            }
            else
            {
                Logger.getInstance().log("Dance barty barty. BUmci Bumci!");
                valuablesToSpend.clear();
            }
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
