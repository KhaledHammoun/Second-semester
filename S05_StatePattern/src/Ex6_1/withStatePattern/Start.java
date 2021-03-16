package Ex6_1.withStatePattern;

public class Start
{
    public static void main(String[] args) {
        Phone phone = new Phone();
        phone.volumeUpButton();
        phone.receiveMessage("Hello world!");
        phone.receiveCall();
        phone.volumeDownButton();
        phone.receiveCall();
        phone.volumeDownButton();
        phone.receiveMessage("Hello world!");
        phone.receiveCall();
        phone.receiveCall();
    }
}
