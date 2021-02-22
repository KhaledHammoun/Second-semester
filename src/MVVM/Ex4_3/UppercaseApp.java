package MVVM.Ex4_3;

import MVVM.Ex4_3.core.ModelFactory;
import MVVM.Ex4_3.core.ViewHandler;
import MVVM.Ex4_3.core.ViewModelFactory;
import javafx.application.Application;
import javafx.stage.Stage;

public class UppercaseApp extends Application
{
  @Override public void start(Stage stage) throws Exception
  {
    ModelFactory modelFactory = new ModelFactory();
    ViewModelFactory viewModelFactory = new ViewModelFactory(modelFactory);
    ViewHandler viewHandler = new ViewHandler(viewModelFactory);
    viewHandler.start("Uppercase");
  }
}
