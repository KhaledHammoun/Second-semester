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
    try
    {
      Socket socket = new Socket("127.0.0.1", 9596);
      ObjectOutputStream outToServer = new ObjectOutputStream(socket.getOutputStream());
      ObjectInputStream inFromServer = new ObjectInputStream(socket.getInputStream());

      new Thread(() -> listenForMessage(outToServer, inFromServer)).start();
    }
    catch (IOException e)
    {
      System.out.println(
          "Failed to initiate the socket communication with Server in Client socket");
    }
  }

  private void listenForMessage(ObjectOutputStream ouToServer,
      ObjectInputStream inFromServer)
  {
    try
    {
      ouToServer.writeUnshared(new Request(RequestType.LISTEN, null));
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

  }

  @Override public void addFriend(User user, User friend)
  {
    try
    {
      Socket socket = new Socket("127.0.0.1", 9596);
      ObjectOutputStream outToServer = new ObjectOutputStream(socket.getOutputStream());
      ObjectInputStream inFromServer = new ObjectInputStream(socket.getInputStream());
      User[] friendToAdd = {user, friend};
      outToServer.writeUnshared(new Request(RequestType.ADDFRIEND, friendToAdd));
    }
    catch (IOException e)
    {
      System.out.println("Error while sending request to the server for adding a friend");
    }
  }

  @Override public void sendMessage(Message message)
  {

  }

  @Override public Users getAllUsers()
  {
    return null;
  }

  @Override public List<User> getFriends()
  {
    return null;
  }

  @Override public void receiveMessage(Message message)
  {
    support.firePropertyChange(RequestType.NEWMESSAGE.toString(), null, message);
  }

  @Override public void addPropertyChangeListener(String name,
      PropertyChangeListener listener)
  {

  }

  @Override public void removePropertyChangeListener(String name,
      PropertyChangeListener listener)
  {

  }
}
