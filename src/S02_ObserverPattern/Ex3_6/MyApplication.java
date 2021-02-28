package S02_ObserverPattern.Ex3_6;

import S02_ObserverPattern.Ex3_6.temperature.mediator.TemperatureModel;
import S02_ObserverPattern.Ex3_6.temperature.mediator.TemperatureModelManager;
import S02_ObserverPattern.Ex3_6.temperature.model.Thermometer;
import S02_ObserverPattern.Ex3_6.temperature.view.ViewHandler;
import javafx.application.Application;
import javafx.stage.Stage;

public class MyApplication extends Application
{
  public void start(Stage primaryStage)
  {
    // Model
    TemperatureModel model = new TemperatureModelManager();
    Thread firstThermometer = new Thread(new Thermometer("t1", 15, 6, model));
    Thread secondThermometer = new Thread(new Thermometer("t2", 15, 1, model));

    // View
    ViewHandler view = new ViewHandler(model);
    firstThermometer.start();
    secondThermometer.start();
    view.start(primaryStage);
  }
}
