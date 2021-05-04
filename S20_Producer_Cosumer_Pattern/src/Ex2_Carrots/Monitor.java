package Ex2_Carrots;

import java.util.LinkedList;
import java.util.Queue;

public class Monitor
{
    private Queue<Carrot> carrots;

    public Monitor()
    {
        this.carrots = new LinkedList<>();
    }

    public synchronized void peel()
    {
        while (carrots.size() >= 4)
        {
            try
            {
                System.out.println(Thread.currentThread().getName() + " is waiting for free space for carrots.");
                wait();
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }
        carrots.add(new Carrot());
        System.out.println(Thread.currentThread().getName() + " peeled a carrot " + size());
    }

    public synchronized void eat()
    {
        if (carrots.size() == 0)
        {
            try
            {
                System.out.println(Thread.currentThread().getName() + " is waiting for carrots.");
                wait();
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }
        carrots.remove();
        System.out.println(Thread.currentThread().getName() + " ate a carrot " + size());
    }

    public synchronized int size()
    {
        return carrots.size();
    }
}
