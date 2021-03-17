package client.network;

import shared.*;
import shared.util.PropertyChangeSubject;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.List;

public class ClientSocket implements Client
{
  private PropertyChangeSupport support = new PropertyChangeSupport(this);

  public ClientSocket()
  {

  }

  @Override public void startClient()
  {
    new Thread(this::listenForMessage).start();
    new Thread(this::getUsers).start();
    new Thread(this::getFriends).start();
  }

  private void listenForMessage()
  {
    try
    {
      Socket socket = new Socket("127.0.0.1", 9596);
      ObjectOutputStream outToServer = new ObjectOutputStream(
          socket.getOutputStream());
      ObjectInputStream inFromServer = new ObjectInputStream(
          socket.getInputStream());

      outToServer.writeUnshared(new Request(RequestType.LISTEN, null));
      while (true)
      {
        Request request = (Request) inFromServer.readUnshared();
        receiveMessage((Message) request.getArgument());
      }
    }
    catch (IOException | ClassNotFoundException e)
    {
      System.out.println("Message failed to be received in the Client socket.");
    }
  }

  @Override public void addUser(User user)
  {
    try
    {
      Socket socket = new Socket("127.0.0.1", 9596);
      ObjectOutputStream outToServer = new ObjectOutputStream(
          socket.getOutputStream());
      ObjectInputStream inFromServer = new ObjectInputStream(
          socket.getInputStream());

      outToServer.writeUnshared(new Request(RequestType.ADDUSER, user));
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
      ObjectInputStream inFromServer = new ObjectInputStream(
          socket.getInputStream());
      User[] friendToAdd = {user, friend};
      outToServer
          .writeUnshared(new Request(RequestType.ADDFRIEND, friendToAdd));
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
      ObjectInputStream inFromServer = new ObjectInputStream(
          socket.getInputStream());

      outToServer.writeUnshared(new Request(RequestType.SENDMESSAGE, message));
    }
    catch (IOException e)
    {
      System.out.println("Error while sending the message to the server");
    }
  }

  @Override public void getUsers()
  {
    try
    {
      Socket socket = new Socket("127.0.0.1", 9596);
      ObjectOutputStream outToServer = new ObjectOutputStream(
          socket.getOutputStream());
      ObjectInputStream inFromServer = new ObjectInputStream(
          socket.getInputStream());

      outToServer.writeUnshared(new Request(RequestType.NEWUSER, null));

      while (true)
      {
        User user = (User) inFromServer.readUnshared();
        support.firePropertyChange(RequestType.NEWUSER.toString(), null, user);
      }
    }
    catch (IOException | ClassNotFoundException e)
    {
      System.out.println("Error while getting all the users form the server");
    }
  }

  @Override public void getFriends()
  {
    try
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
