package S03_MVVM.Ex4_4.temperature.core;

import S03_MVVM.Ex4_4.temperature.view.TemperatureViewModel;

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
