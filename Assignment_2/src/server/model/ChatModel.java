package server.model;

import shared.User;
import shared.util.PropertyChangeSubject;

public interface ChatModel extends PropertyChangeSubject
{
  void addFriend(User user, User friend);
}
