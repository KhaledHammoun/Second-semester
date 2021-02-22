package MVVM.Ex4_4.temperature.core;

import MVVM.Ex4_4.temperature.mediator.TemperatureModel;
import MVVM.Ex4_4.temperature.view.TemperatureViewController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Region;
import javafx.stage.Stage;

public class ViewHandler extends Application
{
  private Stage primaryStage;
  private Scene currentScene;

  private TemperatureViewController temperatureViewController;
  private ViewModelFactory viewModelFactory;

  public ViewHandler(ViewModelFactory viewModelFactory)
  {
    this.viewModelFactory = viewModelFactory;
  }

  public void start(Stage primaryStage)
  {
    this.primaryStage = primaryStage;
    openView("temperature");
  }

  public void openView(String id)
  {
    Parent root = null;

    try
    {
      FXMLLoader loader = new FXMLLoader();
      loader.setLocation(getClass().getResource("../view/TemperatureView.fxml"));
      root = loader.load();
      temperatureViewController = loader.getController();
      temperatureViewController.init(this,
          viewModelFactory.getTemperatureViewModel());
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }
    currentScene = new Scene(root);
    primaryStage.setScene(currentScene);
    primaryStage.show();
  }

}
