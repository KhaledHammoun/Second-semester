package server.network;

import server.model.ChatModel;
import shared.Message;
import shared.Request;
import shared.RequestType;
import shared.User;

import java.beans.PropertyChangeEvent;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ServerSocketHandler implements Runnable
{
  private Socket socket;
  private ChatModel chatModel;
  private Pool connections;
  private ObjectOutputStream outToClient;
  private ObjectInputStream inFromClient;

  public ServerSocketHandler(Socket socket, ChatModel chatModel,
      Pool connections) throws IOException
  {
    this.socket = socket;
    this.chatModel = chatModel;
    this.connections = connections;
    outToClient = new ObjectOutputStream(socket.getOutputStream());
    inFromClient = new ObjectInputStream(socket.getInputStream());
  }

  @Override public void run()
  {
    try
    {
      Request request = (Request) inFromClient.readUnshared();

      if (request.getRequest().equals(RequestType.LISTEN))
      {
        chatModel.addPropertyChangeListener(RequestType.NEWMESSAGE.toString(), this::message);
      }
      // TODO: 16-03-2021 Add the rest of the checks
    }
    catch (IOException | ClassNotFoundException e)
    {
      System.out.println("Error in ServerSocketHandler.");
    }
  }

  private void message(PropertyChangeEvent event)
  {
    Message message = new Message((User) event.getOldValue(), (String) event.getNewValue());
    connections.broadcastMessage(message);
  }
}
