package MVVM.Ex4_3.core;

import MVVM.Ex4_3.view.log.LogViewController;
import MVVM.Ex4_3.view.uppercase.UppercaseViewController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ViewHandler
{
  private Stage stage;
  private Scene scene;
  private ViewModelFactory viewModelFactory;

  public ViewHandler(ViewModelFactory viewModelFactory)
  {
    this.viewModelFactory = viewModelFactory;
  }

  public void start(String view) throws Exception
  {
    openView(view);
  }

  public void openView(String view) throws IOException
  {
    FXMLLoader loader = new FXMLLoader();
    if (view.equals("Log"))
    {
      loader.setLocation(getClass().getResource("../view/log/LogView.fxml"));
    }
    else
    {
      loader.setLocation(
          getClass().getResource("../view/uppercase/" + view + "View.fxml"));
    }
    Parent root = null;

    root = loader.load();

    if (view.equals("Log"))
    {
      LogViewController logViewController = loader.getController();
      logViewController.init(this, viewModelFactory.getLogViewModel());
    }
    else
    {
      UppercaseViewController uppercaseViewController = loader.getController();
      uppercaseViewController.init(viewModelFactory.getUppercaseVM(), this);
    }
    scene = new Scene(root);
    stage = new Stage();
    stage.setScene(scene);
    stage.show();
  }
}
