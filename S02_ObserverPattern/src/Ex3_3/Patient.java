package Ex3_3;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class Patient implements PropertyChangeListener
{
  private int waitingNumber;
  private PropertyChangeSubject subject;

  public Patient(int waitingNumber, PropertyChangeSubject subject)
  {
    this.waitingNumber = waitingNumber;
    this.subject = subject;
    subject.addPropertyChangeListener(this);
    System.out.println("Patient " + waitingNumber + " entered the waiting room.");
  }
  @Override public void propertyChange(PropertyChangeEvent evt)
  {
    System.out.println("Patient " + waitingNumber + " looks up.");
    if (waitingNumber == (int)evt.getNewValue())
    {
      System.out.println("Patient " + waitingNumber + " goes to the doctors room.");
      subject.removePropertyChangeListener(this);
    }
    else if (waitingNumber != (int)evt.getNewValue())
    {
      System.out.println("Patient " + waitingNumber + " goes back to looking at the phone.");
    }
  }
}
