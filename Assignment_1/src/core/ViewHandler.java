package core;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import view.logsview.LogsViewController;
import view.mainview.MainViewController;
import view.powersettingview.PowerSettingViewController;

import java.io.IOException;

public class ViewHandler
{
  private Stage stage;
  private Stage logsStage;
  private Scene logListScene;
  private ViewModelFactory viewModelFactory;

  public ViewHandler(Stage stage, ViewModelFactory viewModelFactory)
  {
    this.stage = stage;
    stage.setAlwaysOnTop(true);
    this.viewModelFactory = viewModelFactory;
  }

  public void start(String view)
  {
    if (view.equals("main"))
    {
      openMainView();
    }
    else if (view.equals("power"))
    {
      openPowerSettingView();
    }
    else
    {
      openLogsView();
    }
  }

  private void openMainView()
  {
    Scene scene = null;
    try
    {
      FXMLLoader loader = new FXMLLoader();
      loader.setLocation(getClass().getResource("../view/mainview/MainView.fxml"));
      Parent root = loader.load();
      MainViewController controller = loader.getController();
      controller.init(viewModelFactory.getMainViewModel(), this);
      stage.setTitle("Summer house heating");
      scene = new Scene(root);
    }
    catch (IOException e)
    {

    }
    stage.setScene(scene);
    stage.show();
  }

  private void openPowerSettingView()
  {
    Scene scene = null;
    try
    {
      FXMLLoader loader = new FXMLLoader();
      loader.setLocation(getClass().getResource(
          "../view/powersettingview/PowerSettingView.fxml"));
      Parent root = loader.load();
      PowerSettingViewController controller = loader.getController();
      controller.init(viewModelFactory.getPowerSettingViewModel(), this);
      stage.setTitle("Power setting");
      scene = new Scene(root);
    }
    catch (IOException e)
    {

    }
    stage.setScene(scene);
    stage.show();
  }

  private void openLogsView()
  {
    if (logsStage == null)
    {
      logsStage = new Stage();
      logListScene = null;
      try
      {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("../view/logsview/LogsView.fxml"));
        Parent root = loader.load();
        LogsViewController controller = loader.getController();
        controller.init(viewModelFactory.getLogsViewModel());
        logsStage.setTitle("Measurements");
        logListScene = new Scene(root);
      }
      catch (IOException e)
      {

      }
    }
    logsStage.setScene(logListScene);
    logsStage.show();
  }
}
