package Ex22_1_LoggingFeature;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Log
{
    private Queue<LogLine> logs;
    private File logFile;
    private DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
    private static Log instance;
    private static final Lock instanceLock = new ReentrantLock();
    private final Lock addLock = new ReentrantLock();

    private Log()
    {
        logs = new LinkedList<>();
        Date date = Calendar.getInstance().getTime();
        String fileName = new SimpleDateFormat("yyyy-MM-dd").format(date);
        logFile = new File(fileName);
    }

    public static Log getInstance()
    {
        if (instance == null)
        {
            synchronized (instanceLock)
            {
                if (instance == null)
                {
                    instance = new Log();
                }
            }
        }
        return instance;
    }

    public void addLog(String logEntry)
    {
        if (logEntry == null || "".equals(logEntry))
        {
            System.out.println("Invalid log entry");
            return;
        }
        addLock.lock();
        LogLine toAdd = new LogLine(logEntry, dateFormat.format(new Date()));
        System.out.println(toAdd);
        logs.add(toAdd);
        addToFile(toAdd);
        addLock.unlock();
    }

    public synchronized Queue<LogLine> getAll()
    {
        return logs;
    }

    private synchronized void addToFile(LogLine toAdd)
    {
        if(toAdd == null)
        {
            return;
        }
        BufferedWriter out = null;
        try
        {
            out = new BufferedWriter(new FileWriter(logFile, true));
            out.write(toAdd.toString());
        }
        catch (IOException e)
        {
            System.out.println("Error while writing to file!");
        }
        finally
        {
            try
            {
                out.close();
            }
            catch (IOException e)
            {
                System.out.println("Could not close the file writer!");
            }
        }
    }
}
