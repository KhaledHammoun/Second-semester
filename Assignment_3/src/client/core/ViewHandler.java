package client.core;

import client.util.View;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ViewHandler
{
  private Stage stage;
  private static ViewHandler viewHandler;
  private static Lock lock = new ReentrantLock();

  private ViewHandler()
  {
    this.stage = new Stage();
  }

  public static ViewHandler getViewHandler()
  {
    if (viewHandler == null)
    {
      synchronized (lock)
      {
        if (viewHandler == null)
        {
          viewHandler = new ViewHandler();
        }
      }
    }
    return viewHandler;
  }

  public void start()
  {
    ViewFactory.init(stage);
    openLogInView();
  }

  public void startView(View view)
  {
    switch (view)
    {
      case LOGIN:
        openLogInView();
        break;
      case FRIEND:
        openFriendsView();
        break;
      case CHAT_VIEW:
        openChatView();
        break;
      case FIND_FRIEND:
        openFindFriendsView();
            break;
    }
  }

  private void openFindFriendsView()
  {
    Scene scene = ViewFactory.getScene(View.FIND_FRIEND);
    stage.setTitle("Find friends");
    stage.setScene(scene);
    stage.show();
  }

  private void openLogInView()
  {
    Scene scene = ViewFactory.getScene(View.LOGIN);
    stage.setTitle("Log in");
    stage.setScene(scene);
    stage.show();
  }

  private void openFriendsView()
  {
    Scene scene = ViewFactory.getScene(View.FRIEND);
    stage.setTitle("Friends");
    stage.setScene(scene);
    stage.show();
  }

  private void openChatView()
  {
    Scene scene = ViewFactory.getScene(View.CHAT_VIEW);
    stage.setTitle("Chat");
    stage.setScene(scene);
    stage.show();
  }
}
