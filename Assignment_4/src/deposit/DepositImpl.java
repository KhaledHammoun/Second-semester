package deposit;

import multiton.MinedValuable;
import singleton.Logger;
import utility.collection.ArrayList;
import utility.collection.ListADT;

public class DepositImpl implements Deposit
{
    private ListADT<MinedValuable> items;
    private int capacity;

    public DepositImpl(int capacity)
    {
        items = new ArrayList<>();
        this.capacity = capacity;
    }

    @Override
    public synchronized void put(MinedValuable item)
    {
        while (isFull())
        {
            try
            {
                Logger.getInstance().log("Miner is waiting for space.");
                wait();
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }
        Logger.getInstance().log("Miner deposits a valuable.");
        items.add(item);
        notifyAll();

    }

    @Override
    public synchronized MinedValuable take()
    {
        while (isEmpty())
        {
            Logger.getInstance().log("Valuable transporter is waiting for valuables to be mined.");
            try
            {
                wait();
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }

        Logger.getInstance().log("Valuable transporter is taking from the deposit.");
        MinedValuable toReturn = items.get(0);
        items.remove(toReturn);
        notifyAll();

        return toReturn;
    }

    @Override
    public synchronized boolean isEmpty()
    {
        return items.size() == 0;
    }

    @Override
    public synchronized boolean isFull()
    {
        return items.size() == capacity;
    }

    @Override
    public synchronized int size()
    {
        return items.size();
    }
}
