package S03_MVVM.Ex4_2;

import S03_MVVM.Ex4_2.model.ModelFactory;
import S03_MVVM.Ex4_2.view.ViewHandler;
import S03_MVVM.Ex4_2.viewmodel.ViewModelFactory;
import javafx.application.Application;
import javafx.stage.Stage;

public class UppercaseApp extends Application
{
  @Override public void start(Stage stage) throws Exception
  {
    ModelFactory modelFactory = new ModelFactory();
    ViewModelFactory viewModelFactory = new ViewModelFactory(modelFactory);
    ViewHandler viewHandler = new ViewHandler(viewModelFactory);
    viewHandler.start();
  }
}
