package Ex2_Carrots;

public class CarrotEater implements Runnable
{
    private Monitor monitor;

    public CarrotEater(Monitor monitor)
    {
        this.monitor = monitor;
    }

    @Override
    public void run()
    {
        while (true)
        {
            monitor.eat();
            try
            {
                Thread.sleep(1500);
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }
    }
}
