package S02_ObserverPattern.Ex3_5;

import java.beans.PropertyChangeEvent;
import java.util.Random;

public class BlindBirdWatcher
{
  private String[] expressions = {"Could you hear that", "Magnificent", "How much I would like to see it"};
  private Random rnd = new Random();

  public BlindBirdWatcher(PropertyChangeSubject subject)
  {
    subject.appPropertyChangeListener(this::react);
  }

  private void react(PropertyChangeEvent evt)
  {
    int rndNum = rnd.nextInt(expressions.length);
    if (evt.getPropertyName().equals("Singing"))
    {
      System.out.println(expressions[rndNum]);
    }
  }
}
