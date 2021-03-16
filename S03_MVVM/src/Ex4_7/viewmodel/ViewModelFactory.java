package Ex4_7.viewmodel;

import Ex4_7.model.ModelFactory;
import Ex4_7.viewmodel.barchart.BarChartViewModel;
import Ex4_7.viewmodel.piechart.PieChartViewModel;
import Ex4_7.viewmodel.textchart.TextViewModel;

public class ViewModelFactory {

    private BarChartViewModel barChartViewModel;
    private PieChartViewModel pieChartViewModel;
    private TextViewModel textViewModel;

    public ViewModelFactory(ModelFactory modelFactory) {
        barChartViewModel = new BarChartViewModel(modelFactory.getDataModel());
        pieChartViewModel = new PieChartViewModel(modelFactory.getDataModel());
        textViewModel = new TextViewModel(modelFactory.getDataModel());
    }

    public BarChartViewModel getBarChartViewModel() {
        return barChartViewModel;
    }

    public PieChartViewModel getPieChartViewModel()
    {
        return pieChartViewModel;
    }

    public TextViewModel getTextViewModel()
    {
        return textViewModel;
    }
}
