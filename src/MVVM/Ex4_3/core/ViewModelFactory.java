package MVVM.Ex4_3.core;

import MVVM.Ex4_3.view.log.LogViewModel;
import MVVM.Ex4_3.view.uppercase.UppercaseViewModel;

public class ViewModelFactory
{
  private ModelFactory modelFactory;
  private UppercaseViewModel viewModel;
  private LogViewModel logViewModel;

  public ViewModelFactory(ModelFactory modelFactory)
  {
    this.modelFactory = modelFactory;
  }

  public UppercaseViewModel getUppercaseVM()
  {
    if (viewModel == null)
    {
      viewModel = new UppercaseViewModel(modelFactory.getTextConverter());
    }
    return viewModel;
  }

  public LogViewModel getLogViewModel()
  {
    if (logViewModel == null)
    {
      logViewModel = new LogViewModel(modelFactory.getTextConverter());
    }
    return logViewModel;
  }
}
