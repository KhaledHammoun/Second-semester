package Ex4_1.view;
//import viewmodel.ViewModelFactory;

import Ex4_1.viewmodel.TimestampViewModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class TimestampController {

    @FXML private Label numberOfUpdates;
    @FXML private Label eventLabel;


    private TimestampViewModel viewModel;

    public TimestampController() {
    }

    public void init(TimestampViewModel viewModel) {
        this.viewModel = viewModel;

        eventLabel.textProperty().bind(viewModel.updateTimeStampProperty());
        numberOfUpdates.textProperty().bind(viewModel.getNumberOfUpdatesProperty());
    }

    public void onUpdateButton(ActionEvent actionEvent) {
        viewModel.updateTimestamp();

    }
}
