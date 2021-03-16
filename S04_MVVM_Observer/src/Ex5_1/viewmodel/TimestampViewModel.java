package Ex5_1.viewmodel;

import Ex5_1.model.DataModel;
import Ex5_1.model.PropertyChangeSubject;
import javafx.application.Platform;
import javafx.beans.property.Property;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.paint.Paint;

import java.beans.PropertyChangeEvent;

public class TimestampViewModel {

    private StringProperty updateTimeStamp;
    private Property<Paint> circleProperty;
    private StringProperty numberOfUpdates;

    private DataModel model;

    public TimestampViewModel(DataModel model) {
        this.model = model;
        updateTimeStamp = new SimpleStringProperty("Last update: ");
        numberOfUpdates=new SimpleStringProperty("0");
        circleProperty = new SimpleObjectProperty<>();
        ((PropertyChangeSubject) model).addPropertyChangeListener(this::propertyChange);
    }

    public void propertyChange(PropertyChangeEvent evt) {
        model.increaseNumberOfUpdates();
        Platform.runLater(() -> {
            if (evt == null)
            {
                circleProperty.setValue(Paint.valueOf("Yellow"));
            }
            else if (evt.getPropertyName().equals("Updated"))
            {
                updateTimeStamp.setValue("Last updated: " + model.getLastUpdateTimeStamp());
                numberOfUpdates.setValue("Number of updates:" + model.getNumberOfUpdates());
            }
            else if (evt.getPropertyName().equals("ColourChange"))
            {
                circleProperty.setValue(Paint.valueOf(evt.getNewValue().toString()));
            }
        });
    }

    public StringProperty updateTimeStampProperty() {
        return updateTimeStamp;
    }

    public StringProperty numberOfUpdatesProperty() {
        return numberOfUpdates;
    }

    public Property<Paint> circleProperty()
    {
        return circleProperty;
    }
}
