package Ex6_1.withStatePattern;

public class SoundState implements PhoneState {
    @Override
    public void onReceiveMessage(String txt, Phone phone) {
        phone.beepBeep();
        System.out.println(txt);
    }

    @Override
    public void onReceiveCall(Phone phone) {
        phone.playRingTone();
    }

    @Override
    public void onVolumeButtonUp(Phone phone) {
        int vol = phone.getVolume();
        if(vol < 100) {
            phone.turnVolumeUp();
        }
    }

    @Override
    public void onVolumeButtonDown(Phone phone) {
        int vol = phone.getVolume();
        if(vol > 1) {
            phone.turnVolumeDown();
        }
        else if (vol == 1)
        {
            phone.turnVolumeDown();
            phone.setState(new VibrateState());
        }
        else {
            phone.turnVolumeDown();
            phone.setState(new SilentState());
        }
    }
}
