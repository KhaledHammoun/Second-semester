package server.model;

import shared.Message;
import shared.User;
import shared.util.PropertyChangeSubject;

public interface ChatModel extends PropertyChangeSubject
{
  void addUser(User user);
  void addFriend(User user, User friend);
  void sendMessage(Message message);
  int getNumberOfUsers();
}
