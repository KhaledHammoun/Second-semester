package S02_ObserverPattern.Ex3_4;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class ScoreBoard implements PropertyChangeListener
{
  private int counterDreamTeam=0;
  private int counterOldBoys=0;

  public ScoreBoard(PropertyChangeSubject subject)
  {
    subject.addPropertyChangeListener(this);
  }

  @Override public void propertyChange(PropertyChangeEvent evt)
  {
    if("Dream Team scored goal".equalsIgnoreCase(evt.getPropertyName()))
    {
      counterDreamTeam++;
    }
    else if("Old Boys scored goal".equalsIgnoreCase(evt.getPropertyName()))
    {
      counterOldBoys++;
    }
    System.out.println("Score is: "+counterDreamTeam+"-"+counterOldBoys);
  }
}
