package Ex5_3.core;

import Ex5_3.view.addtask.AddTaskViewModel;
import Ex5_3.view.nexttask.NextTaskViewModel;
import Ex5_3.view.showtask.ShowTaskViewModel;

public class ViewModelFactory
{
  private ModelFactory modelFactory;
  private AddTaskViewModel addTaskViewModel;
  private NextTaskViewModel nextTaskViewModel;
  private ShowTaskViewModel showTaskViewModel;

  public ViewModelFactory(ModelFactory modelFactory)
  {
    this.modelFactory = modelFactory;
  }

  public AddTaskViewModel getAddTaskViewModel()
  {
    if (addTaskViewModel == null)
    {
      addTaskViewModel = new AddTaskViewModel(modelFactory.getTaskModel());
    }
    return addTaskViewModel;
  }

  public NextTaskViewModel getNextTaskViewModel()
  {
    if (nextTaskViewModel == null)
    {
      nextTaskViewModel = new NextTaskViewModel(modelFactory.getTaskModel());
    }
    return nextTaskViewModel;
  }

  public ShowTaskViewModel getShowTaskViewModel()
  {
    if (showTaskViewModel == null)
    {
      showTaskViewModel = new ShowTaskViewModel(modelFactory.getTaskModel());
    }
    return showTaskViewModel;
  }
}
