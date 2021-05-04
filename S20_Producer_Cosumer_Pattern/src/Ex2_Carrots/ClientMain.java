package Ex2_Carrots;

public class ClientMain
{
    public static void main(String[] args)
    {
        Monitor monitor = new Monitor();

        Thread peeler = new Thread(new CarrotPeeler(monitor));
        Thread eater = new Thread(new CarrotEater(monitor));
        Thread eater2 = new Thread(new CarrotEater(monitor));
        Thread eater3 = new Thread(new CarrotEater(monitor));
        Thread eater4 = new Thread(new CarrotEater(monitor));

        peeler.setName("Carrot peeler");
        eater.setName("Carrot eater one");
        eater2.setName("Carrot eater two");
        eater3.setName("Carrot eater three");
        eater4.setName("Carrot eater four");

        peeler.start();
        eater.start();
        eater2.start();
        eater3.start();
        eater4.start();
    }
}
