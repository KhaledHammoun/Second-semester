package Ex11_5.Client.networking;

import javafx.application.Platform;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.io.IOException;
import java.net.Socket;

public class ClientSocket
{
  private StringProperty message;
  private ClientSocketHandler clientSocketHandler;
  private Socket socket;

  public ClientSocket() throws IOException
  {
    this.socket = new Socket("127.0.0.1", 12345);
    this.clientSocketHandler = new ClientSocketHandler(socket, this);
    message = new SimpleStringProperty("Read");
    Thread thread = new Thread(clientSocketHandler);
    thread.start();
  }

  public void sendMessage()
  {
    clientSocketHandler.sendMessage(message.get());
  }

  public void messageReceived(String msg)
  {
    Platform.runLater(() -> {
    message.set(msg);
    });
  }

  public StringProperty messageProperty()
  {
    return message;
  }
}
