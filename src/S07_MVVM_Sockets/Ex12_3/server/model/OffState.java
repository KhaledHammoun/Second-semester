package S07_MVVM_Sockets.Ex12_3.server.model;



public class OffState implements RadiatorState
{
  private final int POWER = 0;

  @Override public void turnUp(Radiator radiator)
  {
    radiator.setPowerState(new Power1State());
  }

  @Override public void turnDown(Radiator radiator)
  {
    // Has nothing to do. Off state is the lowest.
  }

  @Override public int getPower()
  {
    return POWER;
  }
}
