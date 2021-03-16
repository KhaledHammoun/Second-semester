package Ex12_1_Ex12_2.Client.core;


import Ex12_1_Ex12_2.Client.view.TimestampViewModel;

import java.io.IOException;

public class ViewModelFactory {

    private TimestampViewModel timestampViewModel;

    public ViewModelFactory(ModelFactory modelFactory) throws IOException
    {
        timestampViewModel = new TimestampViewModel(modelFactory.getDataModel());
    }

    public TimestampViewModel getTimestampViewModel() {
        return timestampViewModel;
    }
}
