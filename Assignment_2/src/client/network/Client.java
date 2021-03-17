package client.network;

import shared.Users;
import shared.Message;
import shared.User;
import shared.util.PropertyChangeSubject;

import java.util.List;

public interface Client extends PropertyChangeSubject
{
  void startClient();
  void addUser(User user);
  void addFriend(User user, User friend);
  void sendMessage(Message message);
  void getUsers();
  void getFriends();
  void receiveMessage(Message message);
}
