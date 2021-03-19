package client.network;

import shared.Message;
import shared.User;
import shared.util.PropertyChangeSubject;

public interface Client extends PropertyChangeSubject
{
  void startClient();
  void addUser(User user);
  void addFriend(User user, User friend);
  void sendMessage(Message message);
  void receiveMessage(Message message);
  void getNumberOfConnections();
}
