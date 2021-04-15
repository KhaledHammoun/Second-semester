package client.view.chatview;

import client.core.ViewHandler;
import client.core.ViewModelFactory;
import client.util.View;
import client.view.ViewController;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class ChatViewController implements ViewController
{
    @FXML
    private Button numberOfUsersButton;
    @FXML
    private Label userLabel;
    @FXML
    private TextArea receiveMessageTextArea;
    @FXML
    private TextArea messageTextArea;
    private ChatViewModel chatViewModel;
    private ViewHandler viewHandler;

    @Override
    public void init(ViewHandler viewHandler, ViewModelFactory viewModelFactory)
    {
        this.chatViewModel = viewModelFactory.getChatViewModel();
        this.viewHandler = viewHandler;
        receiveMessageTextArea.textProperty().bind(chatViewModel.messageProperty());
        messageTextArea.textProperty().bindBidirectional(chatViewModel.messageToSendProperty());
        userLabel.textProperty().bind(chatViewModel.userProperty());
        numberOfUsersButton.textProperty().bind(chatViewModel.numberOfConnectionsProperty());
    }

    @FXML
    public void onExitButton()
    {
        viewHandler.startView(View.LOGIN);
        chatViewModel.clear();
    }

    @FXML
    public void onFriendsButton()
    {
        viewHandler.startView(View.FRIEND);
    }

    @FXML
    public void onSendMessageButton()
    {
        chatViewModel.sendMessage();
        messageTextArea.clear();
        receiveMessageTextArea.setScrollTop(Double.MAX_VALUE);
    }


    @FXML
    public void onEnter(KeyEvent keyEvent)
    {
        if (keyEvent.getCode().equals(KeyCode.ENTER))
        {
            onSendMessageButton();
        }
    }

    @FXML
    public void onNumberOfUsersButton()
    {
        chatViewModel.getNumberOfConnections();
    }
}
