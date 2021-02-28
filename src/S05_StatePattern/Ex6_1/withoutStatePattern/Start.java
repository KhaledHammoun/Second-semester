package S05_StatePattern.Ex6_1.withoutStatePattern;

public class Start {
    public static void main(String[] args) {
        Phone phone = new Phone();
        phone.volumeUpButton();
        phone.receiveCall();
        phone.volumeDownButton();
        phone.receiveCall();
        phone.volumeDownButton();
        phone.receiveCall();
        phone.goToVibrate();
        phone.receiveCall();
    }
}
