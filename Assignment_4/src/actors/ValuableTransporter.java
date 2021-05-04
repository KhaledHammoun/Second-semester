 package actors;

 import deposit.Deposit;
import multiton.MinedValuable;
 import treasuries.Guardsman;
 import treasuries.TreasureRoomDoor;

import java.util.ArrayList;
import java.util.Random;

 public class ValuableTransporter implements Runnable
{
    private ArrayList<MinedValuable> cargo;
    private TreasureRoomDoor treasure;
    private Deposit deposit;
    private Random rnd;

    public ValuableTransporter(Deposit deposit)
    {
        cargo = new ArrayList<>();
        treasure = Guardsman.getInstance();
        this.deposit = deposit;
        rnd = new Random();
    }

    @Override
    public void run()
    {
        while (true)
        {
            int target = 50 + rnd.nextInt(150);
            double totalPrice = 0;

            while (totalPrice < target)
            {
                MinedValuable toTransport = deposit.take();
                totalPrice += toTransport.getValue();
                cargo.add(toTransport);
            }
            sleep(500, 2000);

            treasure.acquireWrite(this);
            treasure.addValuables(cargo);
            cargo.clear();
            treasure.releaseWrite();

            sleep(2000,1000);
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
