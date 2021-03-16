package Ex5_3.model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.Calendar;

public class TaskModelManager implements TaskModel
{
  private ArrayList<Task> tasks;
  private PropertyChangeSupport support = new PropertyChangeSupport(this);

  public TaskModelManager()
  {
    tasks = new ArrayList<>();
  }

  @Override public void addTask(String owner, String description)
  {
    Task taskToAdd = new Task(owner, description, calcTimeStamp());
    tasks.add(taskToAdd);
    support.firePropertyChange("TaskAdded", -1, taskToAdd);
  }

  private String calcTimeStamp()
  {
    return Calendar.getInstance().getTime().toString();
  }

  @Override public Task getTask()
  {
    Task getLastTask = (new Task(null,"No more available tasks", null));
    if (tasks.size() != 0)
    {
      getLastTask = tasks.get(tasks.size() - 1);
      support.firePropertyChange("TaskRemoved", 1, getLastTask);
      tasks.remove(getLastTask);
    }
    return getLastTask;
  }

  @Override public void addPropertyChangeListener(String name,
      PropertyChangeListener listener)
  {
    support.addPropertyChangeListener(name, listener);
  }

  @Override public void addPropertyChangeListener(
      PropertyChangeListener listener)
  {
    support.addPropertyChangeListener(listener);
  }

  @Override public void removePropertyChangeListener(String name,
      PropertyChangeListener listener)
  {
    support.removePropertyChangeListener(name,listener);
  }

  @Override public void removePropertyChangeListener(
      PropertyChangeListener listener)
  {
    support.removePropertyChangeListener(listener);
  }
}
