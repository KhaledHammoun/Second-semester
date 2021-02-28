package S04_MVVM_Observer.Ex5_1.view;

import S04_MVVM_Observer.Ex5_1.viewmodel.TimestampViewModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.shape.Circle;

import java.beans.PropertyChangeEvent;

//import viewmodel.ViewModelFactory;

public class TimestampController {

  @FXML private Circle circleColour;
  @FXML
    Label eventLabel;
    @FXML
    Label numberOfUpdates;


    private TimestampViewModel viewModel;

    public TimestampController() {
    }

    public void init(TimestampViewModel viewModel) {
        this.viewModel = viewModel;

        eventLabel.textProperty().bind(viewModel.updateTimeStampProperty());
        numberOfUpdates.textProperty().bind(viewModel.numberOfUpdatesProperty());
        circleColour.fillProperty().bind(viewModel.circleProperty());
    }

    public void onUpdateButton(ActionEvent actionEvent) {
        viewModel.propertyChange(null);
    }
}
