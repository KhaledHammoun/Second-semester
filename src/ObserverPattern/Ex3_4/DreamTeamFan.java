package ObserverPattern.Ex3_4;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class DreamTeamFan implements PropertyChangeListener
{
  public DreamTeamFan(PropertyChangeSubject subject)
  {
    subject.addPropertyChangeListener(this);
  }

  public void propertyChange(PropertyChangeEvent evt)
  {
    if("Dream Team scored goal".equalsIgnoreCase(evt.getPropertyName()))
    {
      System.out.println("Dream team: YEAAA!");
    }
    else
      System.out.println("Dream team: BOOOH!");
  }
}
