package ObserverPattern.Ex3_4;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class Medic implements PropertyChangeListener
{

  public Medic(PropertyChangeSubject subject)
  {
    subject.addPropertyChangeListener(this);
  }

  @Override public void propertyChange(PropertyChangeEvent evt)
  {
    if("Dream Team gets penalty".equalsIgnoreCase(evt.getPropertyName()))
    {
      System.out.println("Medics are called to check player from Old Boys.");
    }
    else if("Old Boys get penalty".equalsIgnoreCase(evt.getPropertyName()))
    {
      System.out.println("Medics are called to check player from Dream Team. ");
    }
  }
}
