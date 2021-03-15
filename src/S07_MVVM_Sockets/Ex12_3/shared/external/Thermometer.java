package S07_MVVM_Sockets.Ex12_3.shared.external;


import S07_MVVM_Sockets.Ex12_3.client.core.ModelFactory;

import S07_MVVM_Sockets.Ex12_3.client.mediator.HeaterModel;
import S07_MVVM_Sockets.Ex12_3.shared.util.PropertyChangeSubject;

import java.beans.PropertyChangeEvent;
import java.util.Random;

public class Thermometer implements Runnable
{
  private String id;
  private double t;
  private int d;
  private int p;
  private double t0;
  private HeaterModel heaterModel;

  public Thermometer(String id, double t, int d, ModelFactory model)
  {
    this.id = id;
    this.t = t;
    this.d = d;
    t0 = 5;
    p = 0;
    this.heaterModel = model.getHeaterModel();
    ((PropertyChangeSubject) heaterModel).addPropertyChangeListener("t0", this::setT0);
    ((PropertyChangeSubject) heaterModel).addPropertyChangeListener("HeatingChange", this::setP);
  }

  public void setT0(PropertyChangeEvent evt)
  {
    double value = ((Temperature)evt.getNewValue()).getValue();
    this.t0 = value;
  }

  public void setP(PropertyChangeEvent evt)
  {
    int power = (int)evt.getNewValue();
    p = power;
  }

  public String getId()
  {
    return id;
  }

  public double temperature(double t, int p, int d, double t0, int s)
  {
    double tMax = Math.min(11 * p + 10, 11 * p + 10 + t0);
    tMax = Math.max(Math.max(t, tMax), t0);
    double heaterTerm = 0;
    if (p > 0)
    {
      double den = Math.max((tMax * (20 - 5 * p) * (d + 5)), 0.1);
      heaterTerm = 30 * s * Math.abs(tMax - t) / den;
    }
    double outdoorTerm = (t - t0) * s / 250.0;
    t = Math.min(Math.max(t - outdoorTerm + heaterTerm, t0), tMax);
    return t;
  }

  public double externalTemperature(double t0, double min, double max)
  {
    double left = t0 - min;
    double right = max - t0;
    int sign = Math.random() * (left + right) > left ? 1 : -1;
    t0 += sign * Math.random();
    return t0;
  }

  public void run()
  {
    Random rnd = new Random();
    while (true)
    {
      int rndInt = rnd.nextInt(4000) + 4000;
      t = temperature(t, p, d, t0, 6);
      Temperature temperature = new Temperature(id, t);
      heaterModel.addTemperature(temperature);

      try
      {
        Thread.sleep(rndInt);
      }
      catch (InterruptedException e)
      {

      }
    }
  }
}
