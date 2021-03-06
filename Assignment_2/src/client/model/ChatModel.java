package client.model;

import shared.Message;
import shared.User;
import shared.util.PropertyChangeSubject;

import java.beans.PropertyChangeEvent;

public interface ChatModel extends PropertyChangeSubject
{
  void addUser(User user);
  void addFriend(User friend);
  void sendMessage(Message message);
  void getFriends(PropertyChangeEvent event);
  void receiveMessage(PropertyChangeEvent event);
  void setCurrentUser(User user);
  User getCurrentUser();
  void getNumberOfConnections();
}
