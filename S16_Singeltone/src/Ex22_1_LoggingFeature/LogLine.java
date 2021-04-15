package Ex22_1_LoggingFeature;

import java.io.Serializable;

public class LogLine implements Serializable
{
    private String logEntry;
    private String time;

    public LogLine(String logEntry, String time)
    {
        this.logEntry = logEntry;
        this.time = time;
    }

    public String getLogEntry()
    {
        return logEntry;
    }

    public String toString()
    {
        return time + " " + logEntry;
    }
}
