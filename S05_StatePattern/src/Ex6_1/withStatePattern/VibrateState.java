package Ex6_1.withStatePattern;

public class VibrateState implements PhoneState
{
  @Override public void onReceiveMessage(String txt, Phone phone)
  {
    phone.vibrate();
    System.out.println(txt);
  }

  @Override public void onReceiveCall(Phone phone)
  {
    phone.vibrate();
    phone.lightScreenUp();
  }

  @Override public void onVolumeButtonUp(Phone phone)
  {
    phone.volumeUpButton();
    phone.setState(new SoundState());
  }

  @Override public void onVolumeButtonDown(Phone phone)
  {
    phone.turnVolumeDown();
    phone.setState(new SilentState());
  }
}
