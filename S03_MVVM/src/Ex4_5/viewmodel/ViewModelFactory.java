package Ex4_5.viewmodel;

import Ex4_5.model.ModelFactory;
import Ex4_5.viewmodel.piechart.PieChartViewModel;

public class ViewModelFactory {

    private PieChartViewModel pieChartViewModel;

    public ViewModelFactory(ModelFactory modelFactory) {
        pieChartViewModel = new PieChartViewModel(modelFactory.getDataModel());
    }

    public PieChartViewModel getPieChartViewModel() {
        return pieChartViewModel;
    }
}
