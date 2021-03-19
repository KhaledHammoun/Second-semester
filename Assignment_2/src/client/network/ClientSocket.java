package client.network;

import com.google.gson.Gson;
import shared.*;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ClientSocket implements Client
{
  private PropertyChangeSupport support = new PropertyChangeSupport(this);

  public ClientSocket()
  {

  }

  @Override public void startClient()
  {
    new Thread(this::listenForChanges).start();
  }

  private synchronized void listenForChanges()
  {
    try
    {
      Socket socket = new Socket("127.0.0.1", 9596);
      ObjectOutputStream outToServer = new ObjectOutputStream(socket.getOutputStream());
      ObjectInputStream inFromServer = new ObjectInputStream(socket.getInputStream());

      outToServer.writeUnshared(new Request(RequestType.LISTEN, null));
      while (true)
      {
        Request request = (Request) inFromServer.readUnshared();

        if (request.getRequest().equals(RequestType.NEWMESSAGE))
        {
          receiveMessage((Message) request.getArgument());
        }
        else if (request.getRequest().equals(RequestType.NEWUSER))
        {
          Users users = (Users) request.getArgument();
          System.out.println(request);
          support.firePropertyChange(RequestType.NEWUSER.toString(), -1,
              users);
        }
        else if (request.getRequest().equals(RequestType.NEWFRIEND))
        {
          support
              .firePropertyChange((PropertyChangeEvent) request.getArgument());
        }
      }
    }
    catch (IOException | ClassNotFoundException e)
    {
      System.out.println("Message failed to be received in the Client.");
    }
  }

  @Override public void addUser(User user)
  {
    try
    {
      Socket socket = new Socket("127.0.0.1", 9596);
      ObjectOutputStream outToServer = new ObjectOutputStream(
          socket.getOutputStream());

      outToServer.writeUnshared(new Request(RequestType.ADDUSER, user));
      socket.close();
    }
    catch (IOException e)
    {
      System.out.println(
          "Error while sending request to the server for adding a friend");
    }

  }

  @Override public void addFriend(User user, User friend)
  {
    try
    {
      Socket socket = new Socket("127.0.0.1", 9596);
      ObjectOutputStream outToServer = new ObjectOutputStream(
          socket.getOutputStream());

      User[] friendToAdd = {user, friend};
      outToServer
          .writeUnshared(new Request(RequestType.ADDFRIEND, friendToAdd));
      socket.close();
    }
    catch (IOException e)
    {
      System.out.println(
          "Error while sending request to the server for adding a friend");
    }
  }

  @Override public void sendMessage(Message message)
  {
    try
    {
      Socket socket = new Socket("127.0.0.1", 9596);
      ObjectOutputStream outToServer = new ObjectOutputStream(
          socket.getOutputStream());

      outToServer.writeUnshared(new Request(RequestType.SENDMESSAGE, message));
      socket.close();
    }
    catch (IOException e)
    {
      System.out.println("Error while sending the message to the server");
    }
  }

  @Override public void getUsers()
  {
    /*try
    {
      Socket socket = new Socket("127.0.0.1", 9596);
      ObjectOutputStream outToServer = new ObjectOutputStream(
          socket.getOutputStream());
      ObjectInputStream inFromServer = new ObjectInputStream(
          socket.getInputStream());

      outToServer.writeUnshared(new Request(RequestType.NEWUSER, null));

      while (true)
      {
        Request request = (Request) inFromServer.readUnshared();
        support.firePropertyChange(RequestType.NEWUSER.toString(), null,
            (User) request.getArgument());
      }
    }
    catch (IOException | ClassNotFoundException e)
    {
      System.out.println("Error while getting all the users form the server");
    }*/
  }

  @Override public void getFriends()
  {
    /*try
    {
      Socket socket = new Socket("127.0.0.1", 9596);
      ObjectOutputStream ouToServer = new ObjectOutputStream(
          socket.getOutputStream());
      ObjectInputStream inFromServer = new ObjectInputStream(
          socket.getInputStream());

      ouToServer.writeUnshared(new Request(RequestType.NEWFRIEND, null));
      while (true)
      {
        User friend = (User) inFromServer.readUnshared();

        support
            .firePropertyChange(RequestType.NEWFRIEND.toString(), null, friend);
      }
    }
    catch (IOException | ClassNotFoundException e)
    {
      e.printStackTrace();
    }
*/
  }

  @Override public void receiveMessage(Message message)
  {
    support
        .firePropertyChange(RequestType.NEWMESSAGE.toString(), null, message);
  }

  @Override public void addPropertyChangeListener(String name,
      PropertyChangeListener listener)
  {
    if (name == null)
    {
      support.addPropertyChangeListener(listener);
    }
    else
    {
      support.addPropertyChangeListener(name, listener);
    }
  }

  @Override public void removePropertyChangeListener(String name,
      PropertyChangeListener listener)
  {
    if (name == null)
    {
      support.removePropertyChangeListener(listener);
    }
    else
    {
      support.removePropertyChangeListener(name, listener);
    }
  }
}
