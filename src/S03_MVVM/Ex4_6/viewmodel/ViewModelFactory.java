package S03_MVVM.Ex4_6.viewmodel;

import S03_MVVM.Ex4_6.model.ModelFactory;
import S03_MVVM.Ex4_6.viewmodel.piechart.PieChartViewModel;
import S03_MVVM.Ex4_6.viewmodel.textchart.TextViewModel;

public class ViewModelFactory {

    private PieChartViewModel pieChartViewModel;
    private TextViewModel textViewModel;

    public ViewModelFactory(ModelFactory modelFactory) {
        pieChartViewModel = new PieChartViewModel(modelFactory.getDataModel());
        textViewModel = new TextViewModel(modelFactory.getDataModel());
    }

    public PieChartViewModel getPieChartViewModel() {
        return pieChartViewModel;
    }

    public TextViewModel getTextViewModel()
    {
        return textViewModel;
    }
}
