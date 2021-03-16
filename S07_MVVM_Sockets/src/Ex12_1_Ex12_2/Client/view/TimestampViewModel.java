package S07_MVVM_Sockets.Ex12_1_Ex12_2.Client.view;

import S07_MVVM_Sockets.Ex12_1_Ex12_2.Client.model.DataModel;
import S07_MVVM_Sockets.Ex12_1_Ex12_2.shared.util.PropertyChangeSubject;
import javafx.application.Platform;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.beans.PropertyChangeEvent;
import java.util.Date;

public class TimestampViewModel {

    private StringProperty updateTimeStamp;

    private StringProperty numberOfUpdates;

    private DataModel model;

    public TimestampViewModel(DataModel model) {
        this.model = model;
        updateTimeStamp = new SimpleStringProperty("Last update: ");
        numberOfUpdates=new SimpleStringProperty("0");
        ((PropertyChangeSubject) model).addPropertyChangeListener((PropertyChangeEvent evt) -> this.updated());
    }

    public void updated() {
        Platform.runLater(() -> {
            updateTimeStamp.setValue("Last updated: " + model.getLastUpdateTimeStamp());
            numberOfUpdates.setValue("Number of updates:" + model.getNumberOfUpdates());
        });
    }

    public void updateTimestamp() {
        model.setTimeStamp(new Date());
    }

    public StringProperty updateTimeStampProperty() {
        return updateTimeStamp;
    }

    public StringProperty numberOfUpdatesProperty() {
        return numberOfUpdates;
    }
}
