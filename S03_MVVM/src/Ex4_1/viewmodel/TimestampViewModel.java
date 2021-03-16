package Ex4_1.viewmodel;

import Ex4_1.model.DataModel;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class TimestampViewModel {

    private StringProperty updateTimeStamp;
    private StringProperty numberOfUpdates;

    private DataModel model;

    public TimestampViewModel(DataModel model) {
        this.model = model;
        updateTimeStamp = new SimpleStringProperty("Last update: ");
        numberOfUpdates = new SimpleStringProperty("Number of updates: ");
    }

    public void updateTimestamp() {
        updateTimeStamp.setValue("Last updated: " + model.getLastUpdateTimeStamp());
        model.increase();
        numberOfUpdates.setValue("Number of updates: " + model.getNumberOfUpdates());
    }


    public StringProperty updateTimeStampProperty() {
        return updateTimeStamp;
    }

    public StringProperty getNumberOfUpdatesProperty()
    {
        return numberOfUpdates;
    }
}
