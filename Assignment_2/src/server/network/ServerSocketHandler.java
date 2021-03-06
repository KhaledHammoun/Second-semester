package server.network;

import server.model.ChatModel;
import shared.*;

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
        connections.addConnection(this);
        chatModel.addPropertyChangeListener(RequestType.NEWMESSAGE.toString(),
            this::message);
        chatModel.addPropertyChangeListener(RequestType.NEWFRIEND.toString(),
            this::newFriendAdded);
        chatModel.addPropertyChangeListener(RequestType.NEWUSER.toString(),
            this::newUserAdded);
      }
      else if (request.getRequest().equals(RequestType.ADDFRIEND))
      {
        User[] users = (User[]) request.getArgument();
        chatModel.addFriend(users[0], users[1]);
      }
      else if (request.getRequest().equals(RequestType.ADDUSER))
      {
        chatModel.addUser((User) request.getArgument());
      }
      else if (request.getRequest().equals(RequestType.SENDMESSAGE))
      {
        Message message = (Message) request.getArgument();
        connections.broadcastMessage(message);
      }
      else if (request.getRequest().equals(RequestType.GETCONNECTIONS))
      {
        getNumberOfConnections();
      }
    }
    catch (IOException | ClassNotFoundException e)
    {
      System.out.println("Error in ServerSocketHandler.");
    }
  }

  private void getNumberOfConnections()
  {
    try
    {
      int connected = connections.getNumberOfConnections();
      outToClient
          .writeUnshared(new Request(RequestType.GETCONNECTIONS, connected));
    }
    catch (IOException e)
    {
      System.out
          .println("Failed sending the number of connections to the client");
    }
  }

  private void newUserAdded(PropertyChangeEvent event)
  {
    try
    {
      Users users = (Users) event.getNewValue();
      outToClient.writeUnshared(new Request(RequestType.NEWUSER, users));
      outToClient.reset();
    }
    catch (IOException e)
    {
      System.out.println("Error while fetching data from server.");
    }
  }

  private void newFriendAdded(PropertyChangeEvent event)
  {
    try
    {
      outToClient.writeUnshared(new Request(RequestType.NEWFRIEND, event));
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
  }

  private void message(PropertyChangeEvent event)
  {
    Message message = (Message) event.getNewValue();
    connections.broadcastMessage(message);
  }

  public void sendMessage(Message message)
  {
    try
    {
      outToClient.writeUnshared(new Request(RequestType.NEWMESSAGE, message));
    }
    catch (IOException e)
    {
      System.out.println("Failed to send the message to client");
    }
  }
}
