package S02_ObserverPattern.Ex3_5;

import java.beans.PropertyChangeEvent;
import java.util.Random;

public class BirdWatcher
{
  private String[] expressions = {"Ooh", "How nice", "Would you look at that"};
  private Random rnd = new Random();

  public BirdWatcher(PropertyChangeSubject subject)
  {
    subject.appPropertyChangeListener(this::react);
  }

  private void react(PropertyChangeEvent evt)
  {
    int rndNum = rnd.nextInt(expressions.length);
    System.out.println(expressions[rndNum]);
  }
}
