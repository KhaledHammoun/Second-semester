package S04_MVVM_Observer.Ex5_2.core;

import S04_MVVM_Observer.Ex5_2.view.TemperatureViewModel;

public class ViewModelFactory
{
  private ModelFactory modelFactory;
  private TemperatureViewModel temperatureViewModel;

  public ViewModelFactory(ModelFactory modelFactory)
  {
    this.modelFactory = modelFactory;
  }

  public TemperatureViewModel getTemperatureViewModel()
  {
    if (temperatureViewModel == null)
    {
      temperatureViewModel = new TemperatureViewModel(
          modelFactory.getTemperatureModel());
    }
    return temperatureViewModel;
  }
}
