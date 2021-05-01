package Ex1_Logger;

public class LogLevelController implements Logger
{
    enum Level
    {
        SPARSE,
        VERBOSE
    }

    private ConsoleLogger logger;
    private Level loggerLevel;

    public LogLevelController(Level level)
    {
        loggerLevel = level;
        logger = new ConsoleLogger();
    }

    @Override
    public void log(String txt)
    {
        if (loggerLevel.equals(Level.SPARSE))
        {
            if (txt.toLowerCase().contains("error"))
            {
                logger.log(txt);
            }
        }
        else
        {
            logger.log(txt);
        }
    }

}
