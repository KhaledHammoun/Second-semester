package treasuties;

import multiton.MinedValuable;
import singleton.Logger;

import java.util.ArrayList;
import java.util.List;

public class TreasureRoom implements TreasureRoomDoor
{
    private List<MinedValuable> items;
    private int writers;
    private int waitingWriters;
    private int readers;

    public TreasureRoom()
    {
        items = new ArrayList<>();
    }

    @Override
    public synchronized void acquireRead(Object who)
    {
        while(waitingWriters > 0 || writers > 0)
        {
            try
            {
                wait();
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }
        readers++;
    }

    @Override
    public synchronized void acquireWrite(Object who)
    {
        waitingWriters++;
        while (readers > 0 || writers > 0)
        {
            try
            {
                wait();
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }
        waitingWriters--;
        writers++;
    }

    @Override
    public synchronized void releaseRead()
    {
        readers--;
        notifyAll();
    }

    @Override
    public synchronized void releaseWrite()
    {
        writers--;
        if (waitingWriters == 0)
        {
            notifyAll();
        }
    }

    @Override
    public synchronized void addValuable(ArrayList<MinedValuable> valuables)
    {
        Logger.getInstance().log("Valuables are added to the treasury");
        items.addAll(valuables);
    }

    @Override
    public synchronized MinedValuable spendValuable()
    {
        MinedValuable valuable = null;
        if (items.size() != 0)
        {
            valuable = items.get(0);
            items.remove(valuable);
        }
        Logger.getInstance().log("Valuables are taken from the treasury.");
        return valuable;
    }

    @Override
    public synchronized double countValuable()
    {
        double result = 0.0;
        for (MinedValuable item : items)
        {
            result += item.getValue();
        }
        return result;
    }
}
