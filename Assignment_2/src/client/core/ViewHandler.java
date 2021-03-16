package client.core;

import client.view.chatview.ChatViewController;
import client.view.findfriends.FindFriendsController;
import client.view.friends.FriendsViewController;
import client.view.login.LogInController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ViewHandler
{
  // TODO: 16-03-2021 Opens all the vies in new Stage. Fix it!

  private ViewModelFactory viewModelFactory;
  private Stage stage;
  private Parent root;

  public ViewHandler(ViewModelFactory viewModelFactory, Stage stage)
  {
    this.stage = stage;
    this.viewModelFactory = viewModelFactory;
  }

  public void startView(String view)
  {
    switch (view)
    {
      case "logIn":
        openLogInView();
        break;
      case "friends":
        openFriendsView();
        break;
      case "chat":
        openChatView();
        break;
      case "find":
        openFindFriendsView();
            break;
    }
  }

  private void openFindFriendsView()
  {
    Scene scene = null;
    try
    {
      FXMLLoader loader = new FXMLLoader();
      loader.setLocation(getClass().getResource("../view/findfriends/FindFriends.fxml"));
      root = loader.load();
      FindFriendsController controller = loader.getController();
      controller.init(viewModelFactory.getFindFriendsViewModel(), this);
      scene = new Scene(root);
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
    stage.setScene(scene);
    stage.setTitle("Find friends");
    stage.show();
  }

  private void openLogInView()
  {
    Scene scene = null;
    try
    {
      FXMLLoader loader = new FXMLLoader();
      loader.setLocation(getClass().getResource("../view/login/LogIn.fxml"));
      root = loader.load();
      LogInController controller = loader.getController();
      controller.init(viewModelFactory.getLogInViewModel(), this);
      scene = new Scene(root);
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
    stage.setScene(scene);
    stage.setTitle("Log in");
    stage.show();
  }

  private void openFriendsView()
  {
    Scene scene = null;
    try
    {
      FXMLLoader loader = new FXMLLoader();
      loader.setLocation(getClass().getResource("../view/friends/FriendsView.fxml"));
      root = loader.load();
      FriendsViewController controller = loader.getController();
      controller.init(viewModelFactory.getFriendsViewModel(), this);
      scene = new Scene(root);
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
    stage.setScene(scene);
    stage.setTitle("Friends");
    stage.show();
  }

  private void openChatView()
  {
    Scene scene = null;
    try
    {
      FXMLLoader loader = new FXMLLoader();
      loader.setLocation(getClass().getResource("../view/chatview/ChatView.fxml"));
      root = loader.load();
      ChatViewController controller = loader.getController();
      controller.init(viewModelFactory.getChatViewModel(), this);
      scene = new Scene(root);
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
    stage.setScene(scene);
    stage.setTitle("Chat");
    stage.show();
  }
}
