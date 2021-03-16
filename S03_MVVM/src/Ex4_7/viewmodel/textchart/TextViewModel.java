package Ex4_7.viewmodel.textchart;

import Ex4_7.model.DataModel;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class TextViewModel
{
  private StringProperty x;
  private StringProperty y;
  private StringProperty z;
  private StringProperty updateTimeStamp;
  private DataModel model;

  public TextViewModel(DataModel model)
  {
    this.model = model;
    x = new SimpleStringProperty();
    y = new SimpleStringProperty();
    z = new SimpleStringProperty();
    updateTimeStamp = new SimpleStringProperty("Last updated: ");
  }
  public void updateTextFields()
  {
    double[] data = model.getDataValues();
    x.set(String.valueOf(data[0]));
    y.set(String.valueOf(data[1]));
    z.set(String.valueOf(data[2]));
    updateTimeStamp.set("Last updated: " + model.getLastUpdateTimeStamp());
  }

  public StringProperty xCoordinateProperty()
  {
    return x;
  }

  public StringProperty yCoordinateProperty()
  {
    return y;
  }

  public StringProperty zCoordinateProperty()
  {
    return z;
  }

  public StringProperty updateTimeStampProperty()
  {
    return updateTimeStamp;
  }

  public void saveChanges()
  {
    System.out.println(x);
    System.out.println(y);
    System.out.println(z);
    double xDouble = Double.parseDouble(x.getValue().toString());
    double yDouble = Double.parseDouble(y.getValue().toString());
    double zDouble = Double.parseDouble(z.getValue().toString());
    double[] values = new double[3];

    values[0] = xDouble;
    values[1] = yDouble;
    values[2] = zDouble;

    model.saveData(values);
  }
}
