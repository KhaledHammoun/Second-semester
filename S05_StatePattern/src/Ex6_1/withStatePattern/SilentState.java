package Ex6_1.withStatePattern;

public class SilentState implements PhoneState
{
  @Override public void onReceiveMessage(String txt, Phone phone)
  {
    phone.lightScreenUp();
    System.out.println(txt);
  }

  @Override public void onReceiveCall(Phone phone)
  {
    phone.lightScreenUp();
  }

  @Override public void onVolumeButtonUp(Phone phone)
  {
    phone.setState(new SoundState());
    phone.turnVolumeUp();
  }

  @Override public void onVolumeButtonDown(Phone phone)
  {
    System.out.println("Already on silent mode");
  }
}
