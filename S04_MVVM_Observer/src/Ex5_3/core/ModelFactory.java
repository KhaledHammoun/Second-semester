package Ex5_3.core;

import Ex5_3.model.TaskModel;
import Ex5_3.model.TaskModelManager;

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
