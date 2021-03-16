package Ex5_3;

import Ex5_3.core.ModelFactory;
import Ex5_3.core.ViewHandler;
import Ex5_3.core.ViewModelFactory;
import javafx.application.Application;
import javafx.stage.Stage;

public class TaskListApp extends Application
{
  @Override public void start(Stage stage) throws Exception
  {
    ModelFactory modelFactory = new ModelFactory();
    ViewModelFactory viewModelFactory = new ViewModelFactory(modelFactory);
    ViewHandler viewHandler = new ViewHandler(stage, viewModelFactory);
    viewHandler.start("main");
  }
}
