package Ex3_5;

import java.beans.PropertyChangeListener;

public interface PropertyChangeSubject
{
  public void appPropertyChangeListener(String name, PropertyChangeListener listener);
  public void appPropertyChangeListener(PropertyChangeListener listener);
  public void removePropertyChangeListener(String name, PropertyChangeListener listener);
  public void removePropertyChangeListener(PropertyChangeListener listener);
}
