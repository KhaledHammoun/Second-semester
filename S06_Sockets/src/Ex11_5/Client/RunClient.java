package Ex11_5.Client;

import Ex11_5.Client.ui.ChatController;
import Ex11_5.Client.networking.ClientSocket;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class RunClient extends Application
{
  @Override public void start(Stage stage) throws Exception
  {
    ClientSocket clientSocket = new ClientSocket();
    startView(clientSocket);
  }

  private static void startView(ClientSocket clientSocket) throws IOException
  {
    FXMLLoader loader = new FXMLLoader(RunClient.class.getResource("ui/chat.fxml"));
    Parent root = loader.load();
    ChatController controller = loader.getController();
    controller.init(clientSocket);
    Scene scene = new Scene(root);
    Stage stage = new Stage();
    stage.setScene(scene);
    stage.show();
  }

}
