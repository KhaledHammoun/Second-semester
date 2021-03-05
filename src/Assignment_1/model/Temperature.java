                                                  package Assignment_1.model;

import java.text.DecimalFormat;

public class Temperature
{
  private String id;
  private double value;
  private DateTime timeStamp;
  private DecimalFormat format = new DecimalFormat("#.##");

  public Temperature(String id, double value)
  {
    this.id = id;
    this.value = Math.round(value*100.00)/100.00;
    timeStamp = new DateTime();
  }

  public String getId()
  {
    return id;
  }

  public double getValue()
  {
    return value;
  }

  public void setValue(double value)
  {
    this.value = value;
  }

  public String getTimeStamp()
  {
    return timeStamp.getTimestamp();
  }
}
