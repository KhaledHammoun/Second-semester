package S07_MVVM_Sockets.Ex12_3.server.model;



public class Power3State implements RadiatorState
{
  private final int POWER = 3;
  private Thread boostMode;

  public Power3State(Radiator radiator)
  {
    boostMode = new Thread(() -> {
      try
      {
        Thread.sleep(40000);
        turnDown(radiator);
      }
      catch (InterruptedException e)
      {
        System.out.println("Interrupted");
      }
    });
    boostMode.setDaemon(true);
    boostMode.start();
  }
  @Override public void turnUp(Radiator radiator)
  {
    // Has nothing to do. Power 3 is the highest.
  }

  @Override public void turnDown(Radiator radiator)
  {
    boostMode.interrupt();
    radiator.setPowerState(new Power2State());
  }

  @Override public int getPower()
  {
    return POWER;
  }
}
