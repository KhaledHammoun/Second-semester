package S03_MVVM.Ex4_1.viewmodel;

import S03_MVVM.Ex4_1.model.ModelFactory;

public class ViewModelFactory {

    private TimestampViewModel timestampViewModel;

    public ViewModelFactory(ModelFactory modelFactory) {
        timestampViewModel = new TimestampViewModel(modelFactory.getDataModel());
    }

    public TimestampViewModel getTimestampViewModel() {
        return timestampViewModel;
    }
}
