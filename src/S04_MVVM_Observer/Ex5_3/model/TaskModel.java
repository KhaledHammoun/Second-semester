package S04_MVVM_Observer.Ex5_3.model;

public interface TaskModel extends PropertyChangeSubject
{
  public void addTask(String owner, String description);
  public Task getTask();
}
