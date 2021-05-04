package client.view.findfriends;

import client.core.ViewHandler;
import client.core.ViewModelFactory;
import client.util.View;
import client.view.ViewController;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import shared.User;

import java.util.Date;

public class FindFriendsController implements ViewController
{
    @FXML
    private TableColumn<User, String> registered;
    @FXML
    private TableColumn<User, Date> usernameColumn;
    @FXML
    private TableView<User> friendsTable;
    private FindFriendsViewModel findFriendsViewModel;
    private ViewHandler viewHandler;

    @Override
    public void init(ViewHandler viewHandler, ViewModelFactory viewModelFactory)
    {
        this.findFriendsViewModel = viewModelFactory.getFindFriendsViewModel();
        this.viewHandler = viewHandler;
        usernameColumn.setCellValueFactory(new PropertyValueFactory<>("username"));
        registered.setCellValueFactory(new PropertyValueFactory<>("registered"));

        friendsTable.setItems(findFriendsViewModel.getUsers());
    }

    @FXML
    public void onBackButton()
    {
        viewHandler.startView(View.FRIEND);
    }

    @FXML
    public void onAddFriendsButton()
    {
        User user = friendsTable.getSelectionModel().getSelectedItem();
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
