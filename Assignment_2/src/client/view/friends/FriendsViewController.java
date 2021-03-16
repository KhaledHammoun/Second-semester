package client.view.friends;

import client.core.ViewHandler;
import client.view.login.LogInViewModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import javax.sound.midi.Soundbank;

public class FriendsViewController
{
  @FXML private TableView friendsTable;
  @FXML private TableColumn statusColumn;
  @FXML private TableColumn usernameColumn;
  @FXML private TableColumn lasActiveColumn;
  private FriendsViewModel friendsViewModel ;
  private ViewHandler viewHandler;

  @FXML public void init(FriendsViewModel friendsViewModel, ViewHandler viewHandler)
  {
    this.friendsViewModel = friendsViewModel;
    this.viewHandler = viewHandler;
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
