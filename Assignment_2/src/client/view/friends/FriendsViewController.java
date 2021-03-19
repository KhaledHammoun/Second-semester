package client.view.friends;

import client.core.ViewHandler;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import shared.User;

import java.util.Date;

public class FriendsViewController
{
  @FXML private TableView<User> friendsTable;
  @FXML private TableColumn<User, String> usernameColumn;
  @FXML private TableColumn<User, Date> registered;
  private FriendsViewModel friendsViewModel;
  private ViewHandler viewHandler;


  @FXML public void init(FriendsViewModel friendsViewModel, ViewHandler viewHandler)
  {
    this.friendsViewModel = friendsViewModel;
    this.viewHandler = viewHandler;

    usernameColumn.setCellValueFactory(new PropertyValueFactory<>("username"));
    registered.setCellValueFactory(new PropertyValueFactory<>("registered"));

    friendsTable.setItems(friendsViewModel.getFriends());
  }

  @FXML public void onFindFriendsButton()
  {
    viewHandler.startView("find");
  }

  @FXML public void onBackButton()
  {
    viewHandler.startView("chat");
  }
}
