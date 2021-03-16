package client.view.findfriends;

import client.core.ViewHandler;
import client.view.login.LogInViewModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import shared.User;

public class FindFriendsController
{
  @FXML private TableColumn lasActiveColumn;
  @FXML private TableColumn usernameColumn;
  @FXML private TableView friendsTable;
  private FindFriendsViewModel findFriendsViewModel;
  private ViewHandler viewHandler;

  @FXML public void init(FindFriendsViewModel findFriendsViewModel, ViewHandler viewHandler)
  {
    this.findFriendsViewModel = findFriendsViewModel;
    this.viewHandler = viewHandler;
  }

  @FXML public void onBackButton(ActionEvent actionEvent)
  {
    viewHandler.startView("friends");
  }

  @FXML public void onAddFriendsButton(ActionEvent actionEvent)
  {
    User user = (User) friendsTable.getSelectionModel().getSelectedItem();
    findFriendsViewModel.addFriend(user);
  }
}
