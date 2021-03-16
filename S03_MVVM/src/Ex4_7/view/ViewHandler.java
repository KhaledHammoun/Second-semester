package Ex4_7.view;

import Ex4_7.view.piechart.PieChartController;
import Ex4_7.view.barchart.BarChartController;
import Ex4_7.view.textchart.TextController;
import Ex4_7.viewmodel.ViewModelFactory;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ViewHandler {

    private ViewModelFactory viewModelFactory;

    public ViewHandler(ViewModelFactory viewModelFactory) {
        this.viewModelFactory = viewModelFactory;
    }

    public void start(String view) throws Exception{
        openView(view);
    }

    public void openView(String viewToOpen) throws IOException {
        Stage stage = new Stage();
        Scene scene = null;
        FXMLLoader loader = new FXMLLoader();
        Parent root = null;

        if("PieChart".equals(viewToOpen)) {
            loader.setLocation(getClass().getResource(viewToOpen.toLowerCase()+"/"+ viewToOpen +"View.fxml"));
            root = loader.load();
            PieChartController view = loader.getController();
            view.init(viewModelFactory.getPieChartViewModel(), this);
            stage.setTitle("Pie Chart");
        }
        else if ("Text".equals(viewToOpen))
        {
            loader.setLocation(getClass().getResource("textchart/"+ viewToOpen +"View.fxml"));
            root = loader.load();
            TextController controller = loader.getController();
            controller.init(viewModelFactory.getTextViewModel());
            stage.setTitle("Charts Control");
        }
        else
        {
            loader.setLocation(getClass().getResource(viewToOpen.toLowerCase()+"/"+ viewToOpen +"View.fxml"));
            root = loader.load();
            BarChartController controller = loader.getController();
            controller.init(viewModelFactory.getBarChartViewModel());
            stage.setTitle("Bar Chart view");
        }

        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
