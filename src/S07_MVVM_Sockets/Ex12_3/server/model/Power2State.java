package S07_MVVM_Sockets.Ex12_3.server.model;



public class Power2State implements RadiatorState
{
  private final int POWER = 2;

  @Override public void turnUp(Radiator radiator)
  {
    radiator.setPowerState(new Power3State(radiator));
  }

  @Override public void turnDown(Radiator radiator)
  {
    radiator.setPowerState(new Power1State());
  }

  @Override public int getPower()
  {
    return POWER;
  }
}
