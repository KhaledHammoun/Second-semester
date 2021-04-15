package client.view.chatview;

import client.model.ChatModel;
import javafx.application.Platform;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.control.Alert;
import shared.Message;
import shared.RequestType;
import shared.User;

import java.beans.PropertyChangeEvent;

public class ChatViewModel
{
    private ChatModel chatModel;
    private StringProperty message;
    private StringProperty messageToSend;
    private StringBuilder newMessage;
    private StringProperty user;
    private StringProperty numberOfConnections;


    public ChatViewModel(ChatModel chatModel)
    {
        this.chatModel = chatModel;
        message = new SimpleStringProperty();
        messageToSend = new SimpleStringProperty();
        newMessage = new StringBuilder();
        user = new SimpleStringProperty("Logged in as: ");
        numberOfConnections = new SimpleStringProperty("Number of users");

        chatModel.addPropertyChangeListener(RequestType.NEW_MESSAGE.toString(),
                                            (x) -> setMessage((Message) x.getNewValue()));
        chatModel.addPropertyChangeListener(RequestType.CURRENT_USER.toString(), this::setUser);
        chatModel.addPropertyChangeListener(RequestType.GET_CONNECTIONS.toString(), this::numberOfConnections);
        chatModel.addPropertyChangeListener(RequestType.ALERT.toString(),
                                            (event) -> alertNewFriend((User) event.getNewValue()));
    }

    private void numberOfConnections(PropertyChangeEvent event)
    {
        Platform.runLater(() -> {
            String connected = String.valueOf((int) event.getNewValue());
            numberOfConnections.set(connected);
        });
    }

    private void alertNewFriend(User user)
    {
        Platform.runLater(() -> {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText(user + " added you as a friend.");
            alert.setTitle("New friend");
            alert.show();
        });
    }

    private void setUser(PropertyChangeEvent event)
    {
        user.set("Logged in as: " + event.getNewValue());
    }

    private void setMessage(Message message)
    {
        newMessage.append(message).append("\n\n");
        this.message.set(newMessage.toString());
    }

    public void sendMessage()
    {
        Message message = new Message(chatModel.getCurrentUser(), messageToSend.get());
        chatModel.sendMessage(message);
    }

    public void getNumberOfConnections()
    {
        chatModel.getNumberOfConnections();
    }

    public StringProperty messageProperty()
    {
        return message;
    }

    public StringProperty messageToSendProperty()
    {
        return messageToSend;
    }

    public StringProperty userProperty()
    {
        return user;
    }

    public StringProperty numberOfConnectionsProperty()
    {
        return numberOfConnections;
    }

    public void clear()
    {
        message.set("");
        messageToSend.set("");
    }
}
