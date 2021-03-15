package S07_MVVM_Sockets.Ex12_3.server.model;


import java.beans.PropertyChangeSupport;

public class Radiator
{
  private RadiatorState currentState = new OffState();
  private PropertyChangeSupport support;

  public Radiator(PropertyChangeSupport support)
  {
    this.support = support;
  }

  public void turnUp()
  {
    currentState.turnUp(this);
  }

  public void turnDown()
  {
    currentState.turnDown(this);
  }

  public int getPower()
  {
    return currentState.getPower();
  }

  public void setPowerState(RadiatorState state)
  {
    currentState = state;
    support.firePropertyChange("HeatingChange", -1, getPower());
  }
}
