package client.view.friends;

import client.core.ViewHandler;
import client.core.ViewModelFactory;
import client.util.View;
import client.view.ViewController;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import shared.User;

import java.util.Date;

public class FriendsViewController implements ViewController
{
    @FXML
    private TableView<User> friendsTable;
    @FXML
    private TableColumn<User, String> usernameColumn;
    @FXML
    private TableColumn<User, Date> registered;
    private FriendsViewModel friendsViewModel;
    private ViewHandler viewHandler;

    @Override
    public void init(ViewHandler viewHandler, ViewModelFactory viewModelFactory)
    {
        this.friendsViewModel = viewModelFactory.getFriendsViewModel();
        this.viewHandler = viewHandler;

        usernameColumn.setCellValueFactory(new PropertyValueFactory<>("username"));
        registered.setCellValueFactory(new PropertyValueFactory<>("registered"));

        friendsTable.setItems(friendsViewModel.getFriends());
    }

    @FXML
    public void onFindFriendsButton()
    {
        viewHandler.startView(View.FIND_FRIEND);
    }

    @FXML
    public void onBackButton()
    {
        viewHandler.startView(View.CHAT_VIEW);
    }
}
