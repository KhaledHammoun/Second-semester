package S04_MVVM_Observer.Ex5_2;

import S04_MVVM_Observer.Ex5_2.core.ModelFactory;
import S04_MVVM_Observer.Ex5_2.core.ViewHandler;
import S04_MVVM_Observer.Ex5_2.core.ViewModelFactory;
import S04_MVVM_Observer.Ex5_2.external.Thermometer;
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
