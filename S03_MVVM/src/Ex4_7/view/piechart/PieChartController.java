package Ex4_7.view.piechart;


import Ex4_7.view.ViewHandler;
import Ex4_7.viewmodel.piechart.PieChartViewModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class PieChartController {

    public Button barChartButton;
    @FXML
    Label eventLabel;

    @FXML
    PieChart pieChart;

    private PieChartViewModel viewModel;
    private ViewHandler viewHandler;

    private PieChart.Data x = new PieChart.Data("X", 0);
    private PieChart.Data y = new PieChart.Data("Y", 0);
    private PieChart.Data z = new PieChart.Data("Z", 0);

    public PieChartController() {
    }

    public void init(PieChartViewModel pieChartViewModel, ViewHandler viewHandler) {
        this.viewModel = pieChartViewModel;
        this.viewHandler = viewHandler;

        x.pieValueProperty().bind(viewModel.xProperty());

        y.pieValueProperty().bind(viewModel.yProperty());
        z.pieValueProperty().bind(viewModel.zProperty());

        eventLabel.textProperty().bind(viewModel.updateTimeStampProperty());

        ObservableList<PieChart.Data> datas = FXCollections.observableArrayList(x, y, z);
        pieChart.setData(datas);
    }

    public void onUpdateButton(ActionEvent actionEvent) {
        viewModel.updatePieChart();
    }

    @FXML public void onEditButton(ActionEvent actionEvent)
    {
        try
        {
            viewHandler.start("Text");
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public void onBarChartButton(ActionEvent actionEvent)
    {
        try
        {
            viewHandler.start("BarChart");
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
