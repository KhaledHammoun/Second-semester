package Ex2_Carrots;

import javax.sound.midi.MidiFileFormat;

public class CarrotPeeler implements Runnable
{
    private Monitor monitor;

    public CarrotPeeler(Monitor monitor)
    {
        this.monitor = monitor;
    }

    @Override
    public void run()
    {
        while (true)
        {
            for (int i = 0; i < 20 - monitor.size(); i++)
            {
                monitor.peel();
                try
                {
                    Thread.sleep(1000);
                }
                catch (InterruptedException e)
                {
                    e.printStackTrace();
                }

            }
        }
    }
}
