package client.view.login;

import client.util.View;
import client.core.ViewHandler;
import client.core.ViewModelFactory;
import client.view.ViewController;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

public class LogInController implements ViewController
{
    @FXML
    private TextField userNameTextField;
    private LogInViewModel logInViewModel;
    private ViewHandler viewHandler;

    @Override
    public void init(ViewHandler viewHandler, ViewModelFactory viewModelFactory)
    {
        this.logInViewModel = viewModelFactory.getLogInViewModel();
        this.viewHandler = viewHandler;
        userNameTextField.textProperty().bindBidirectional(logInViewModel.usernameProperty());
    }

    @FXML
    public void onLogInButton()
    {
        logInViewModel.LogIn();
        viewHandler.startView(View.CHAT_VIEW);
    }

    @FXML
    public void onInfoButton()
    {
        Alert info = new Alert(Alert.AlertType.INFORMATION);
        info.setContentText("Type your username if existing user and press Login."
                            + "\nIf a new user, type your preferred username and press log in. The system"
                            + " will automatically create your account.");
        info.setHeaderText("INFO");
        info.setHeight(300);
        info.show();
    }

    @FXML
    public void onEnterPressed()
    {
        onLogInButton();
    }
}
