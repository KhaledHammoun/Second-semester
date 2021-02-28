package S04_MVVM_Observer.Ex5_3.core;

import S04_MVVM_Observer.Ex5_3.view.addtask.AddTaskController;
import S04_MVVM_Observer.Ex5_3.view.nexttask.NextTaskController;
import S04_MVVM_Observer.Ex5_3.view.showtask.ShowTaskController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ViewHandler
{
  private Stage stage;
  private ViewModelFactory viewModelFactory;

  public ViewHandler(Stage stage, ViewModelFactory viewModelFactory)
  {
    this.stage = stage;
    this.viewModelFactory = viewModelFactory;
  }

  public void start(String view)
  {
    try
    {
      openView(view);
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
  }

  private void openView(String view) throws IOException
  {
    FXMLLoader loader = new FXMLLoader();
    Parent root = null;
    if (view.equals("add"))
    {
      loader.setLocation(getClass().getResource("../view/addtask/AddTask.fxml"));
      root = loader.load();
      AddTaskController controller = loader.getController();
      controller.init(this, viewModelFactory.getAddTaskViewModel());
      stage.setTitle("Add task");
    }
    else if (view.equals("next"))
    {
      loader.setLocation(getClass().getResource("../view/nexttask/NextTask.fxml"));
      root = loader.load();
      NextTaskController controller = loader.getController();
      controller.init(this, viewModelFactory.getNextTaskViewModel());
      stage.setTitle("Nex task");
    }
    else
    {
      loader.setLocation(getClass().getResource("../view/showtask/ShowTask.fxml"));
      root = loader.load();
      ShowTaskController controller = loader.getController();
      controller.init(this, viewModelFactory.getShowTaskViewModel());
      stage.setTitle("All tasks");
    }
    Scene scene = new Scene(root);
    stage.setScene(scene);
    stage.show();

  }
}
