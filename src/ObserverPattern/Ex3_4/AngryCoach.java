package ObserverPattern.Ex3_4;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class AngryCoach implements PropertyChangeListener
{
  private String teamName;

  public AngryCoach(PropertyChangeSubject subject,String teamName)
  {
    this.teamName=teamName;
    subject.addPropertyChangeListener(this);
  }

  @Override public void propertyChange(PropertyChangeEvent evt)
  {
    if (teamName.equalsIgnoreCase(new SoccerMatch().getTeam0()))
    {
      if ("Dream Team scored goal".equalsIgnoreCase(evt.getPropertyName()))
      {
        System.out.println("Angry coach yells happy!");
      }
      else if ("Old Boys get penalty".equalsIgnoreCase(evt.getPropertyName()))
      {
        System.out.println("Angry coach yells at the judge.");
      }
    }
    else if(teamName.equalsIgnoreCase(new SoccerMatch().getTeam1()))
    {
      if("Old Boys scored goal".equalsIgnoreCase(evt.getPropertyName()))
      {
        System.out.println("Coach is happy");
      }
      else if("Dream team gets penalty".equalsIgnoreCase(evt.getPropertyName()))
      {
        System.out.println("Coach is mad on the Dream team");
      }
    }
  }
}
