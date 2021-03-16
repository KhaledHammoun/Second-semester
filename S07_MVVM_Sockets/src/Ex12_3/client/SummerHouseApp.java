package Ex12_3.client;


import Ex12_3.client.core.ClientFactory;
import Ex12_3.client.core.ModelFactory;
import Ex12_3.client.core.ViewHandler;
import Ex12_3.client.core.ViewModelFactory;
import Ex12_3.shared.Temperature;
import Ex12_3.shared.Thermometer;
import javafx.application.Application;
import javafx.stage.Stage;

import java.util.Random;

public class SummerHouseApp extends Application
{

  @Override public void start(Stage stage) throws Exception
  {
    ClientFactory clientFactory = new ClientFactory();
    ModelFactory modelFactory = new ModelFactory(clientFactory);
    ViewModelFactory viewModelFactory = new ViewModelFactory(modelFactory);
    ViewHandler viewHandler = new ViewHandler(stage, viewModelFactory);
    viewHandler.start("main");

    Thermometer outside = new Thermometer("t0", 15, 1, modelFactory);
    Thermometer inside1 = new Thermometer("t1", 15, 1, modelFactory);
    Thermometer inside2 = new Thermometer("t2", 15, 7, modelFactory);

    runAutoOutsideTemp(modelFactory, outside);
    runAutoInTemp(inside1);
    runAutoInTemp(inside2);
  }

  private void runAutoInTemp(Thermometer inside)
  {
    Thread thread = new Thread(inside);
    thread.setDaemon(true);
    thread.start();
  }

  private void runAutoOutsideTemp(ModelFactory modelFactory, Thermometer outside)
  {
    Thread thread = new Thread(() ->{
      while (true)
      {
        double value = outside.externalTemperature(5,0,20);
        Temperature temperature = new Temperature(outside.getId(), value);
        modelFactory.getHeaterModel().addTemperature(temperature);
        Random rnd = new Random();
        try
        {
          int rndInt = rnd.nextInt(4000)+4000;
          Thread.sleep(rndInt);
        }
        catch (InterruptedException e)
        {

        }

      }
    });
    thread.setDaemon(true);
    thread.start();
  }

}
