package S07_MVVM_Sockets.Ex12_3.client.core;

import S07_MVVM_Sockets.Ex12_3.client.view.logsview.LogsViewModel;
import S07_MVVM_Sockets.Ex12_3.client.view.mainview.MainViewModel;
import S07_MVVM_Sockets.Ex12_3.client.view.powersettingview.PowerSettingViewModel;

public class ViewModelFactory
{
  private MainViewModel mainViewModel;
  private LogsViewModel logsViewModel;
  private PowerSettingViewModel powerSettingViewModel;
  private ModelFactory modelFactory;

  public ViewModelFactory(ModelFactory modelFactory)
  {
    this.modelFactory = modelFactory;
  }

  public MainViewModel getMainViewModel()
  {
    if (mainViewModel == null)
    {
      mainViewModel = new MainViewModel(modelFactory.getHeaterModel());
    }
    return mainViewModel;
  }

  public LogsViewModel getLogsViewModel()
  {
    if (logsViewModel == null)
    {
      logsViewModel = new LogsViewModel(modelFactory.getHeaterModel());
    }
    return logsViewModel;
  }

  public PowerSettingViewModel getPowerSettingViewModel()
  {
    if (powerSettingViewModel == null)
    {
      powerSettingViewModel = new PowerSettingViewModel(
          modelFactory.getHeaterModel());
    }
    return powerSettingViewModel;
  }
}
