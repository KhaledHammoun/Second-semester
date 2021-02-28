package S03_MVVM.Ex4_4;

import S03_MVVM.Ex4_4.temperature.core.ModelFactory;
import S03_MVVM.Ex4_4.temperature.core.ViewModelFactory;
import S03_MVVM.Ex4_4.temperature.external.Thermometer;
import S03_MVVM.Ex4_4.temperature.core.ViewHandler;
import javafx.application.Application;
import javafx.stage.Stage;

public class MyApplication extends Application
{
  public void start(Stage primaryStage)
  {
    ModelFactory modelFactory = new ModelFactory();
    ViewModelFactory viewModelFactory = new ViewModelFactory(modelFactory);
    ViewHandler view = new ViewHandler(viewModelFactory);

    Thread firstThermometer = new Thread(new Thermometer("t1", 15, 6, modelFactory.getTemperatureModel()));
    Thread secondThermometer = new Thread(new Thermometer("t2", 15, 1, modelFactory.getTemperatureModel()));
    firstThermometer.setDaemon(true);
    secondThermometer.setDaemon(true);
    firstThermometer.start();
    secondThermometer.start();

    view.start(primaryStage);
  }
}
