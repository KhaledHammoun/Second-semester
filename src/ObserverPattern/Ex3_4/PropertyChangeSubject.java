package ObserverPattern.Ex3_4;

import java.beans.PropertyChangeListener;

public interface PropertyChangeSubject
{
  public void addPropertyChangeListener(String name,
      PropertyChangeListener listener);
  public void addPropertyChangeListener(PropertyChangeListener listener);

  public void removePropertyChangeListener(String name,
      PropertyChangeListener listener);
  public void removePropertyChangeListener(PropertyChangeListener listener);
}
