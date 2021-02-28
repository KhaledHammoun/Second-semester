package S03_MVVM.Ex4_2.viewmodel;

import S03_MVVM.Ex4_2.model.ModelFactory;

public class ViewModelFactory
{
  private ModelFactory modelFactory;
  private UppercaseViewModel viewModel;

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
}
