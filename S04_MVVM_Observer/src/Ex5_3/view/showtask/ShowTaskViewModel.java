package Ex5_3.view.showtask;

import Ex5_3.model.PropertyChangeSubject;
import Ex5_3.model.Task;
import Ex5_3.model.TaskModel;
import com.sun.javafx.collections.ImmutableObservableList;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.beans.PropertyChangeEvent;

public class ShowTaskViewModel
{
  private ObservableList<Task> tasks;
  private TaskModel taskModel;

  public ShowTaskViewModel(TaskModel taskModel)
  {
    this.taskModel = taskModel;
    this.tasks = FXCollections.observableArrayList();
    ((PropertyChangeSubject) taskModel).addPropertyChangeListener("TaskAdded", this::addTask);
    ((PropertyChangeSubject) taskModel).addPropertyChangeListener("TaskRemoved", this::removeTask);
  }

  private void removeTask(PropertyChangeEvent evt)
  {
    tasks.remove((Task) evt.getNewValue());
  }

  private void addTask(PropertyChangeEvent evt)
  {
    Task taskToObsList = (Task)evt.getNewValue();
    tasks.add(taskToObsList);
  }

  public ObservableList<Task> getTaskList()
  {
    return tasks;
  }
}
