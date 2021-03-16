package client.model;

import shared.Message;
import shared.User;
import shared.Users;
import shared.util.PropertyChangeSubject;

import java.util.List;

public interface ChatModel extends PropertyChangeSubject
{
  void addUser(User user);
  void addFriend(User user, User friend);
  void sendMessage(Message message);
  Users getAllUsers();
  List<User> getFriends();
  Message receiveMessage(Message message);
}
