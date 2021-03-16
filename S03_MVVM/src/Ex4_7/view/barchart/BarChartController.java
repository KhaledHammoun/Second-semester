package Ex4_7.view.barchart;


import Ex4_7.viewmodel.barchart.BarChartViewModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;

public class BarChartController
{

    @FXML
    Label eventLabel;

    @FXML BarChart barChart;

    private BarChartViewModel viewModel;

    private XYChart.Data<String, Number> x = new XYChart.Data<String, Number>("X", 0);
    private XYChart.Data<String, Number> y = new XYChart.Data<String, Number>("Y", 0);
    private XYChart.Data<String, Number> z = new XYChart.Data<String, Number>("Z", 0);

    public BarChartController() {
    }

    public void init(BarChartViewModel barChartViewModel) {
        this.viewModel = barChartViewModel;

        x.YValueProperty().bind(viewModel.xProperty());
        y.YValueProperty().bind(viewModel.yProperty());
        z.YValueProperty().bind(viewModel.zProperty());

        eventLabel.textProperty().bind(viewModel.updateTimeStampProperty());

        XYChart.Series yellowSeries = new XYChart.Series();
        yellowSeries.setName("X");
        yellowSeries.getData().add(x);
        barChart.getData().add(yellowSeries);

        XYChart.Series greenSeries = new XYChart.Series();
        greenSeries.setName("Y");
        greenSeries.getData().add(y);
        barChart.getData().add(greenSeries);

        XYChart.Series redSeries = new XYChart.Series();
        redSeries.setName("Z");
        redSeries.getData().add(z);
        barChart.getData().add(redSeries);
    }

    public void onUpdateButton(ActionEvent actionEvent) {
        viewModel.updatePieChart();
    }
}
