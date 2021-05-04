package actors;

import deposit.Deposit;
import multiton.Valuable;

import java.util.Random;

public class Miner implements Runnable
{
    private Deposit deposit;
    private Random rnd;

    public Miner(Deposit deposit)
    {
        this.deposit = deposit;
        rnd = new Random();
    }

    @Override
    public void run()
    {
        while (true)
        {
            deposit.put(Valuable.getValuable());
            try
            {
                Thread.sleep(rnd.nextInt(1000) + 500);
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }
    }
}
