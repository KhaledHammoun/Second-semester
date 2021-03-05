package Assignment_1.view.mainview;

import Assignment_1.core.ViewHandler;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.shape.Circle;

public class MainViewController
{
  @FXML private Label outsideTempLabel;
  @FXML private Label insideTempTwoLabel;
  @FXML private Label insideTempOneLabel;
  @FXML private Circle warningLight;
  @FXML private Label warningLabel;
  private MainViewModel viewModel;
  private ViewHandler viewHandler;

  @FXML public void onPowerSettingButton(ActionEvent actionEvent)
  {
    viewHandler.start("power");
  }

  @FXML public void onMeasuringLogsButton(ActionEvent actionEvent)
  {
    viewHandler.start("logs");
  }

  public void init(MainViewModel viewModel, ViewHandler viewHandler)
  {
    this.viewModel = viewModel;
    this.viewHandler = viewHandler;

    outsideTempLabel.textProperty().bind(
        viewModel.outsideTemperatureProperty());
    insideTempOneLabel.textProperty().bind(
        viewModel.insideOneTemperatureProperty());
    insideTempTwoLabel.textProperty().bind(
        viewModel.insideTwoTemperatureProperty());
    warningLabel.textProperty().bind(viewModel.warningMessageProperty());
    warningLight.fillProperty().bind(viewModel.warningColourProperty());
  }
}
