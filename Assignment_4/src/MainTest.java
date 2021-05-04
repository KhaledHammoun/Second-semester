import actors.Accountant;
import actors.King;
import actors.Miner;
import actors.ValuableTransporter;
import deposit.Deposit;
import deposit.DepositImpl;

public class MainTest
{
    public static void main(String[] args)
    {
        Deposit deposit = new DepositImpl(50);
        Runnable miner = new Miner(deposit);
        Runnable transporter = new ValuableTransporter(deposit);
        Runnable accountant = new Accountant();
        Runnable king = new King();

        Thread kingThread = new Thread(king);
        Thread minerThread = new Thread(miner);
        Thread transporterThread = new Thread(transporter);
        Thread accountantThread = new Thread(accountant);
//        Thread stopThread = new Thread(() -> {
//            try
//            {
//                Thread.sleep(10000);
//            }
//            catch (InterruptedException e)
//            {
//                e.printStackTrace();
//            }
//            Logger.getInstance().printLogs();
//            System.out.println("I am printing");
//            System.exit(0);
//        });

        kingThread.start();
        minerThread.start();
        transporterThread.start();
        accountantThread.start();
//        stopThread.start();

    }
}
