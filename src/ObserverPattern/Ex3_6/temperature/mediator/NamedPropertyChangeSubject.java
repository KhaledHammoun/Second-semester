package ObserverPattern.Ex3_6.temperature.mediator;

import java.beans.PropertyChangeListener;

public interface NamedPropertyChangeSubject
{
  public void addListener(String name, PropertyChangeListener listener);
  public void removeListener(String name, PropertyChangeListener listener);
}
