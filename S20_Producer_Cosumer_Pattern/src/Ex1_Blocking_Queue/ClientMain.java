package Ex1_Blocking_Queue;

public class ClientMain
{
    public static void main(String[] args)
    {
        Buffer<Integer> test = new BlockingQueue<>(50);

        Thread first = new Thread(() -> {
            for (int i = 0; i < 100; i++)
            {
                test.put(i);
            }
            System.out.println(Thread.currentThread().getName() + " is done.");
        });

        Thread second = new Thread(() -> {
            for (int i = 101; i < 200; i++)
            {
                test.put(i);
            }
            System.out.println(Thread.currentThread().getName() + " is done.");
        });

        Thread third = new Thread(() -> {
            for (int i = 0; i < 100; i++)
            {
                test.take();
            }
            System.out.println(Thread.currentThread().getName() + " is done.");
        });

        Thread fourth = new Thread(() -> {
            for (int i = 0; i < 100; i++)
            {
                test.take();
            }
            System.out.println(Thread.currentThread().getName() + " is done.");
        });

        first.setName("nOne");
        second.setName("nTwo");
        third.setName("nThree");
        fourth.setName("nFour");

        first.start();
        second.start();
        third.start();
        fourth.start();
    }
}
