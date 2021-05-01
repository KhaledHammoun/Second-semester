package Ex3_Threadsafe_Queue;

public class ClientMain
{
    public static void main(String[] args) throws InterruptedException
    {
        StringQueue queue = new ThreadSafeQueue(100000);

        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 33000; i++)
            {
                queue.enqueue("1");
            }
            System.out.println(queue.size());
        });

        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 33000; i++)
            {
                queue.enqueue("2");
            }
            System.out.println(queue.size());
        });

        Thread thread3 = new Thread(() -> {
            for (int i = 0; i < 33000; i++)
            {
                queue.enqueue("3");
            }
            System.out.println(queue.size());
        });

        thread1.start();
        thread2.start();
        thread3.start();
    }
}
