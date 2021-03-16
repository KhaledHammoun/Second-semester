package Ex12_3.view.powersettingview;


import Ex12_3.core.ViewHandler;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class PowerSettingViewController
{
  @FXML private TextField minTempTextField;
  @FXML private TextField maxTempTextField;
  @FXML private TextField powerLevelTextField;
  private PowerSettingViewModel viewModel;
  private ViewHandler viewHandler;

  @FXML public void onSetAlertButton(ActionEvent actionEvent)
  {
    viewModel.setAlert();
  }

  @FXML public void onMeasuringLogsButton(ActionEvent actionEvent)
  {
    viewHandler.start("logs");
  }

  @FXML public void onBackButton(ActionEvent actionEvent)
  {
    viewHandler.start("main");
  }

  @FXML public void onIncreaseButton(ActionEvent actionEvent)
  {
    viewModel.powerUp();
  }

  @FXML public void onDecreaseButton(ActionEvent actionEvent)
  {
    viewModel.powerDown();
  }

  public void init(PowerSettingViewModel viewModel, ViewHandler viewHandler)
  {
    this.viewModel = viewModel;
    this.viewHandler = viewHandler;

    powerLevelTextField.textProperty().bind(viewModel.powerLevelProperty());
    maxTempTextField.textProperty().bindBidirectional(
        viewModel.maxTemperatureProperty());
    minTempTextField.textProperty().bindBidirectional(
        viewModel.minTemperatureProperty());
  }

}
