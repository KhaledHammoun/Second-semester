package Ex12_1_Ex12_2.Client.network;



import Ex12_1_Ex12_2.shared.Request;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Date;

public class SocketClient implements ClientInterface
{
  private PropertyChangeSupport support = new PropertyChangeSupport(this);

  @Override public void startClient()
  {
    try
    {
      Socket socket = new Socket("127.0.0.1", 12345);
      ObjectOutputStream outToServer = new ObjectOutputStream(socket.getOutputStream());
      ObjectInputStream inFromServer = new ObjectInputStream(socket.getInputStream());

      new Thread(() -> {
        try
        {
          listenToServer(inFromServer, outToServer);
        }
        catch (IOException | ClassNotFoundException e)
        {
          e.printStackTrace();
        }
      }).start();
    }
    catch (IOException e)
    {

    }
  }

  private void listenToServer(ObjectInputStream inFromServer, ObjectOutputStream outToServer)
      throws IOException, ClassNotFoundException
  {
    outToServer.writeObject(new Request("Listener", null));
    while (true)
    {
      Request request = (Request) inFromServer.readUnshared();
      support.firePropertyChange(request.getType(), null, request.getArg());
    }
  }

  @Override public String getLastUpdatedTimeStamp()
  {
    try
    {
      Socket socket = new Socket("127.0.0.1", 12345);
      ObjectOutputStream outToServer = new ObjectOutputStream(socket.getOutputStream());
      ObjectInputStream inFromServer = new ObjectInputStream(socket.getInputStream());

      outToServer.writeUnshared(new Request("LastUpdate", null));
      Request request = (Request) inFromServer.readUnshared();
      return request.getArg().toString();
    }
    catch (IOException | ClassNotFoundException e)
    {
      e.printStackTrace();
    }
    return null;
  }

  @Override public int getNumberOfUpdates()
  {
    try
    {
      Socket socket = new Socket("127.0.0.1", 12345);
      ObjectOutputStream outToServer = new ObjectOutputStream(socket.getOutputStream());
      ObjectInputStream inFromServer = new ObjectInputStream(socket.getInputStream());

      outToServer.writeUnshared(new Request("NumberOfUpdates", null));
      Request request = (Request) inFromServer.readUnshared();
      return (int) request.getArg();
    }
    catch (IOException | ClassNotFoundException e)
    {
      e.printStackTrace();
    }
    return 0;
  }

  @Override public void setTimeStamp(Date timeStamp)
  {
    try
    {
      Socket socket = new Socket("127.0.0.1", 12345);
      ObjectOutputStream outToServer = new ObjectOutputStream(socket.getOutputStream());
      ObjectInputStream inFromServer = new ObjectInputStream(socket.getInputStream());

      outToServer.writeUnshared(new Request("UpdateTimeStamp", timeStamp));
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
  }

  @Override public void addPropertyChangeListener(String name,
      PropertyChangeListener listener)
  {
      support.addPropertyChangeListener(name,listener);
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
