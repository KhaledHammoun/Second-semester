package S05_StatePattern.Ex6_1.withStatePattern;

public interface PhoneState {
    void onReceiveMessage(String txt, Phone phone);

    void onReceiveCall(Phone phone);

    void onVolumeButtonUp(Phone phone);

    void onVolumeButtonDown(Phone phone);
}
