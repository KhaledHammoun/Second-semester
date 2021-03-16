package Ex4_7.viewmodel.barchart;


import Ex4_7.model.DataModel;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class BarChartViewModel
{

    private DoubleProperty x;
    private DoubleProperty y;
    private DoubleProperty z;
    private StringProperty updateTimeStamp;

    private DataModel model;

    public BarChartViewModel(DataModel model) {
        this.model = model;
        x = new SimpleDoubleProperty();
        y = new SimpleDoubleProperty();
        z = new SimpleDoubleProperty();
        updateTimeStamp = new SimpleStringProperty("Last update: ");
    }

    public void updatePieChart() {
        double[] vals = model.getDataValues();
        x.setValue(vals[0]);
        y.setValue(vals[1]);
        z.setValue(vals[2]);
        updateTimeStamp.setValue("Last updated: " + model.getLastUpdateTimeStamp());
    }

    public DoubleProperty xProperty() {
        return x;
    }

    public DoubleProperty yProperty() {
        return y;
    }

    public DoubleProperty zProperty() {
        return z;
    }

    public StringProperty updateTimeStampProperty() {
        return updateTimeStamp;
    }
}