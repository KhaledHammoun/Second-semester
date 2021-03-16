package Ex3_4;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class Referee implements PropertyChangeListener
{
  public Referee(PropertyChangeSubject subject)
  {
   subject.addPropertyChangeListener(this);
  }

  @Override public void propertyChange(PropertyChangeEvent evt)
  {
    if("Dream Team gets penalty".equalsIgnoreCase(evt.getPropertyName()))
    {
      System.out.println("Referee gives Dream Team a yellow card for rough tackle.");
    }
    else if("Old Boys get penalty".equalsIgnoreCase(evt.getPropertyName()))
    {
      System.out.println("Referee gives Old Boys a yellow card for rough tackle.");
    }
  }
}
