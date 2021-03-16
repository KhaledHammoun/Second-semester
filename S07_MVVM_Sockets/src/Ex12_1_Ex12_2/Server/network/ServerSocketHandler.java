package S07_MVVM_Sockets.Ex12_1_Ex12_2.Server.network;

import S07_MVVM_Sockets.Ex12_1_Ex12_2.Server.model.DataModel;
import S07_MVVM_Sockets.Ex12_1_Ex12_2.shared.Request;

import java.beans.PropertyChangeEvent;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Date;

public class ServerSocketHandler implements Runnable
{
  private Socket socket;
  private DataModel model;
  private ObjectOutputStream outToClient;
  private ObjectInputStream inFromClient;

  public ServerSocketHandler(Socket socket, DataModel model) throws IOException
  {
    this.socket = socket;
    this.model = model;
    outToClient = new ObjectOutputStream(socket.getOutputStream());
    inFromClient = new ObjectInputStream(socket.getInputStream());
  }

  @Override public void run()
  {
   try
    {
      Request request = (Request) inFromClient.readUnshared();
      switch (request.getType())
      {
        case "Listener":
          model.addPropertyChangeListener("UpdateTimeStamp", this::onUpdate);
          break;
        case "LastUpdate":
          String lastUpdateTimeStamp = model.getLastUpdateTimeStamp();
          outToClient.writeUnshared(new Request("LastUpdate", lastUpdateTimeStamp));
          break;
        case "NumberOfUpdates":
          int numberOfUpdates = model.getNumberOfUpdates();
          outToClient.writeUnshared(new Request("NumberOfUpdates", numberOfUpdates));
          break;
        case "UpdateTimeStamp":
          model.setTimeStamp((Date) request.getArg());
          break;
      }
    }
    catch (IOException | ClassNotFoundException e)
    {
      e.printStackTrace();
    }
  }

  private void onUpdate(PropertyChangeEvent event)
  {
    try
    {
      Request request = new Request(event.getPropertyName(), event.getNewValue());
      outToClient.writeUnshared(request);
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
  }
}
