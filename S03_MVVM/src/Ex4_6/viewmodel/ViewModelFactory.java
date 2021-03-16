package Ex4_6.viewmodel;

import Ex4_6.model.ModelFactory;
import Ex4_6.viewmodel.piechart.PieChartViewModel;
import Ex4_6.viewmodel.textchart.TextViewModel;

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
