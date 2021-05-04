package singleton;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Logger
{
    private List<String> logs;
    private static Logger logger;
    private static final Lock lock = new ReentrantLock();
    private SimpleDateFormat sdf;

    private Logger()
    {
        logs = new ArrayList<>();
        sdf = new SimpleDateFormat("HH:mm:ss.SSS dd/MM/yyyy ");
    }

    public static Logger getInstance()
    {
        if (logger == null)
        {
            synchronized (lock)
            {
                if (logger == null)
                {
                    logger = new Logger();
                }
            }
        }
        return logger;
    }

    public synchronized void log(String log)
    {
        String toAdd = sdf.format(new Date()) + "\nLog: " + log;
        logs.add(toAdd);
        System.out.println(toAdd);
    }

    public synchronized String printLogs()
    {
        String logsToPrint = "";
        for (String log : logs)
        {
            logsToPrint += log + "\n";
        }
        return logsToPrint;
    }
}
