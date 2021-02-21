package ObserverPattern.Ex3_4;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class OldBoysFan implements PropertyChangeListener
{


  public void propertyChange(PropertyChangeEvent evt)
  {
    if("Old Boys scored goal".equalsIgnoreCase(evt.getPropertyName()))
    {
      System.out.println("Old bois fans: YEAAH!");
    } else
      System.out.println("Old boys fans: BOOOOH!");
  }
}
