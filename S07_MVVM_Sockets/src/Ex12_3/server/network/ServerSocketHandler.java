package Ex12_3.server.network;

import Ex12_3.server.mediator.HeaterModel;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ServerSocketHandler implements Runnable
{

  private Socket socket;
  private HeaterModel model;
  private ObjectOutputStream outToClient;
  private ObjectInputStream inFromClient;

  public ServerSocketHandler(Socket socket, HeaterModel model)
      throws IOException
  {
    this.socket = socket;
    this.model = model;
    outToClient = new ObjectOutputStream(socket.getOutputStream());
    inFromClient = new ObjectInputStream(socket.getInputStream());
  }

  @Override public void run()
  {

  }
}
