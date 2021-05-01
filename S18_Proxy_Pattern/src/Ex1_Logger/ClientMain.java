package Ex1_Logger;

public class ClientMain
{
    public static void main(String[] args)
    {
        Logger logger = new LogLevelController(LogLevelController.Level.VERBOSE);

        logger.log("error it is ");
        logger.log("errro it is ");
        logger.log("errro it is ");
    }
}
