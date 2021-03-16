package Ex12_3.network;

import S07_MVVM_Sockets.Ex12_3.shared.Temperature;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ClientSocket implements Client
{
  private PropertyChangeSupport support = new PropertyChangeSupport(this);


  @Override public void startClient()
  {
    try
    {
      Socket socket = new Socket("127.0.0.1", 9596);
      ObjectOutputStream outToServer = new ObjectOutputStream(
          socket.getOutputStream());
      ObjectInputStream inFromServer = new ObjectInputStream(
          socket.getInputStream());
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
  }

  @Override public void addTemperature(Temperature temperature)
  {

  }

  @Override public void turnPowerUp()
  {

  }

  @Override public void turnPowerDown()
  {

  }

  @Override public void setMinMaxTemperature(double minTemperature,
      double maxTemperature)
  {

  }

  @Override public void addPropertyChangeListener(String name,
      PropertyChangeListener listener)
  {
    support.addPropertyChangeListener(name, listener);
  }

  @Override public void addPropertyChangeListener(
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
