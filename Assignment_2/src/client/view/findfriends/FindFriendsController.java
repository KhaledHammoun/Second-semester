package client.view.findfriends;

import client.core.ViewHandler;
import client.view.login.LogInViewModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.DateCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import shared.User;

import java.util.Date;

public class FindFriendsController
{
  @FXML private TableColumn<User, String> registered;
  @FXML private TableColumn<User, Date> usernameColumn;
  @FXML private TableView<User> friendsTable;
  private FindFriendsViewModel findFriendsViewModel;
  private ViewHandler viewHandler;

  @FXML public void init(FindFriendsViewModel findFriendsViewModel, ViewHandler viewHandler)
  {
    this.findFriendsViewModel = findFriendsViewModel;
    this.viewHandler = viewHandler;
    usernameColumn.setCellValueFactory(new PropertyValueFactory<>("username"));
    registered.setCellValueFactory(new PropertyValueFactory<>("registered"));

    friendsTable.setItems(findFriendsViewModel.getUsers());
  }

  @FXML public void onBackButton(ActionEvent actionEvent)
  {
    viewHandler.startView("friends");
  }

  @FXML public void onAddFriendsButton(ActionEvent actionEvent)
  {
    User user = (User) friendsTable.getSelectionModel().getSelectedItem();
    if (user != null)
    {
      findFriendsViewModel.addFriend(user);
    }
    else
    {
      Alert alert = new Alert(Alert.AlertType.ERROR);
      alert.setHeaderText("No user selected");
      alert.setContentText("Please select a user from the list in order to add as a friend.");
      alert.show();
    }
  }
}
