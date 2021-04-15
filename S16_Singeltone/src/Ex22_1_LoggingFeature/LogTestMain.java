package Ex22_1_LoggingFeature;

public class LogTestMain
{
    public static void main(String[] args)
    {
        Log logs = Log.getInstance();

        Thread first = new Thread(() -> {
            for (int i = 0; i < 1000000; i++)
            {
                logs.addLog("testing first thread");
//                try
//                {
//                    Thread.sleep(2000);
//                }
//                catch (InterruptedException e)
//                {
//                    e.printStackTrace();
//                }
            }
            System.out.println(Thread.currentThread().getName() + " " + logs.getAll().size());
        });

        Thread second = new Thread(() -> {
            for (int i = 0; i < 1000000; i++)
            {
                logs.addLog("testing second thread");
//                try
//                {
//                    Thread.sleep(2000);
//                }
//                catch (InterruptedException e)
//                {
//                    e.printStackTrace();
//                }
            }
            System.out.println(Thread.currentThread().getName() + " " + logs.getAll().size());
        });

        first.setName("firstThread");
        second.setName("secondThread");
        first.start();
        second.start();
    }
}
