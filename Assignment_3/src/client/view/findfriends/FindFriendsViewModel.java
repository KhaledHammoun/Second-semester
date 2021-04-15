package client.view.findfriends;

import client.model.ChatModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import shared.RequestType;
import shared.User;
import shared.Users;

import java.beans.PropertyChangeEvent;

public class FindFriendsViewModel
{
  private ChatModel chatModel;
  private ObservableList<User> users;

  public FindFriendsViewModel(ChatModel chatModel)
  {
    this.chatModel = chatModel;
    users = FXCollections.observableArrayList();
    chatModel.addPropertyChangeListener(RequestType.NEW_USER.toString(), this::addUser);
  }

  private void addUser(PropertyChangeEvent event)
  {
    Users newUsers = (Users) event.getNewValue();
    users.clear();
    users.addAll(newUsers.getAllUsers());
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
