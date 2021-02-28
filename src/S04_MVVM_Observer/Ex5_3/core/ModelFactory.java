package S04_MVVM_Observer.Ex5_3.core;

import S04_MVVM_Observer.Ex5_3.model.TaskModel;
import S04_MVVM_Observer.Ex5_3.model.TaskModelManager;

public class ModelFactory
{
    private TaskModel taskModel;

    public TaskModel getTaskModel()
    {
      if (taskModel == null)
      {
        taskModel = new TaskModelManager();
      }
      return taskModel;
    }

}
