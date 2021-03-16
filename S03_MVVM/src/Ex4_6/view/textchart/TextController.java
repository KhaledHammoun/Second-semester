package Ex4_6.view.textchart;

import Ex4_6.viewmodel.textchart.TextViewModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class TextController
{
  @FXML private Label lastUpdated;
  @FXML private TextField yCoordinate;
  @FXML private TextField zCoordinate;
  @FXML private TextField xCoordinate;
  private TextViewModel textViewModel;

  public void init(TextViewModel textViewModel)
  {
    this.textViewModel = textViewModel;
    xCoordinate.textProperty()
        .bindBidirectional(textViewModel.xCoordinateProperty());
    yCoordinate.textProperty()
        .bindBidirectional(textViewModel.yCoordinateProperty());
    zCoordinate.textProperty()
        .bindBidirectional(textViewModel.zCoordinateProperty());
    lastUpdated.textProperty().bind(textViewModel.updateTimeStampProperty());

  }

  @FXML public void onSaveButton(ActionEvent actionEvent)
  {
    textViewModel.saveChanges();
  }

  @FXML public void onUpdateButton(ActionEvent actionEvent)
  {
    textViewModel.updateTextFields();
  }
}
