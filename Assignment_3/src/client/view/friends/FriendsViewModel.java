package client.view.friends;

import client.model.ChatModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import shared.RequestType;
import shared.User;

import java.beans.PropertyChangeEvent;

public class FriendsViewModel
{
  private ChatModel chatModel;
  private ObservableList<User> friends;

  public FriendsViewModel(ChatModel chatModel)
  {
    this.chatModel = chatModel;
    friends = FXCollections.observableArrayList();
    chatModel.addPropertyChangeListener(RequestType.NEW_FRIEND.toString(), this::addNewFriend);
  }

  private void addNewFriend(PropertyChangeEvent event)
  {
    User friend = (User) event.getNewValue();
    if (chatModel.getCurrentUser().equals(event.getOldValue()))
    {
      friends.add(friend);
    }
  }

  public ObservableList<User> getFriends()
  {
    return friends;
  }
}
