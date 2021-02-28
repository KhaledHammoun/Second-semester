package S02_ObserverPattern.Ex3_5;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.Random;

public class Bird implements PropertyChangeSubject
{
  private PropertyChangeSupport support = new PropertyChangeSupport(this);
  private Random rnd = new Random();

  public void wingsFlap()
  {
    System.out.println("Bird is flapping wings.");
    support.firePropertyChange("Wings flapped", 0, 1);
  }

  public void songSinged()
  {
    System.out.println("Bird is singing.");
    support.firePropertyChange("Singing", 0, 1);
  }

  public void start()
  {
    for (int i = 0; i < 10; i++)
    {
      int rndSleep = rnd.nextInt(4000) + 1000;
      int rndNum = rnd.nextInt(2);
      if (rndNum == 0)
      {
        wingsFlap();
      }
      else
      {
        songSinged();
      }

      try
      {
        Thread.sleep(rndSleep);
      }
      catch (InterruptedException e)
      {
        e.printStackTrace();
      }
    }
  }

  @Override public void appPropertyChangeListener(String name,
      PropertyChangeListener listener)
  {
    support.addPropertyChangeListener(name, listener);
  }

  @Override public void appPropertyChangeListener(
      PropertyChangeListener listener)
  {
    support.addPropertyChangeListener(listener);
  }

  @Override public void removePropertyChangeListener(String name,
      PropertyChangeListener listener)
  {
    support.removePropertyChangeListener(name, listener);
  }

  @Override public void removePropertyChangeListener(
      PropertyChangeListener listener)
  {
    support.removePropertyChangeListener(listener);
  }
}
