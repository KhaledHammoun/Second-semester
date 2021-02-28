package S04_MVVM_Observer.Ex5_3.view.nexttask;

import S04_MVVM_Observer.Ex5_3.model.Task;
import S04_MVVM_Observer.Ex5_3.model.TaskModel;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.util.Calendar;

public class NextTaskViewModel
{
  private StringProperty task, creator, date;
  private TaskModel taskModel;

  public NextTaskViewModel(TaskModel taskModel)
  {
    this.taskModel = taskModel;
    task = new SimpleStringProperty();
    creator = new SimpleStringProperty();
    date = new SimpleStringProperty();
  }

  public void getTask()
  {
      Task nextTask = taskModel.getTask();
      task.set(nextTask.getDescription());
      creator.set(nextTask.getOwner());
      date.set(nextTask.getTimeCreated());
  }

  public StringProperty taskProperty()
  {
    return task;
  }

  public StringProperty creatorProperty()
  {
    return creator;
  }

  public StringProperty dateProperty()
  {
    return date;
  }
}
