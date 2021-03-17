package client.view.findfriends;

import client.model.ChatModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import shared.RequestType;
import shared.User;

import java.beans.PropertyChangeEvent;

public class FindFriendsViewModel
{
  private ChatModel chatModel;
  private ObservableList<User> users;

  public FindFriendsViewModel(ChatModel chatModel)
  {
    this.chatModel = chatModel;
    users = FXCollections.observableArrayList();
    chatModel.addPropertyChangeListener(RequestType.NEWUSER.toString(), this::addUser);
  }

  private void addUser(PropertyChangeEvent event)
  {
    User user = (User) event.getNewValue();
    System.out.println(user.getUsername());
    users.add(user);
  }

  public ObservableList<User> getUsers()
  {
    return users;
  }

  public void addFriend(User user)
  {
    chatModel.addFriend(user);
  }
}
