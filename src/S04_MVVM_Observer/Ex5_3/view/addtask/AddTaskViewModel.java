package S04_MVVM_Observer.Ex5_3.view.addtask;

import S04_MVVM_Observer.Ex5_3.model.TaskModel;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class AddTaskViewModel
{
  private StringProperty creator, description;
  private TaskModel taskModel;

  public AddTaskViewModel(TaskModel taskModel)
  {
    this.taskModel = taskModel;
    creator = new SimpleStringProperty();
    description = new SimpleStringProperty();
  }

  public void addTask()
  {
    taskModel.addTask(creator.get(), description.get());
    clear();
  }

  private void clear()
  {
    creator.set("");
    description.set("");
  }

  public StringProperty creatorProperty()
  {
    return creator;
  }

  public StringProperty descriptionProperty()
  {
    return description;
  }
}
