package S03_MVVM.Ex4_3;

import S03_MVVM.Ex4_3.core.ModelFactory;
import S03_MVVM.Ex4_3.core.ViewHandler;
import S03_MVVM.Ex4_3.core.ViewModelFactory;
import javafx.application.Application;
import javafx.stage.Stage;

public class UppercaseApp extends Application
{
  @Override public void start(Stage stage) throws Exception
  {
    ModelFactory modelFactory = new ModelFactory();
    ViewModelFactory viewModelFactory = new ViewModelFactory(modelFactory);
    ViewHandler viewHandler = new ViewHandler(stage, viewModelFactory);
    viewHandler.start("Uppercase");
  }
}
