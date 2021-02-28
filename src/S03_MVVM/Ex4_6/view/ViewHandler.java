package S03_MVVM.Ex4_6.view;


import S03_MVVM.Ex4_6.view.piechart.PieChartController;
import S03_MVVM.Ex4_6.view.textchart.TextController;
import S03_MVVM.Ex4_6.viewmodel.ViewModelFactory;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ViewHandler {

    private Stage stage;
    private Scene scene;
    private ViewModelFactory viewModelFactory;

    public ViewHandler(ViewModelFactory viewModelFactory) {
        this.viewModelFactory = viewModelFactory;
    }

    public void start(String view) throws Exception{
        openView(view);
    }

    public void openView(String viewToOpen) throws IOException {
        stage = new Stage();
        Scene scene = null;
        FXMLLoader loader = new FXMLLoader();
        Parent root = null;

        if ("PieChart".equals(viewToOpen))
        {
            loader.setLocation(getClass().getResource(
                viewToOpen.toLowerCase() + "/" + viewToOpen + "View.fxml"));
        }
        else
        {
            loader.setLocation(getClass().getResource("textchart/TextView.fxml"));
        }

        root = loader.load();


        if("PieChart".equals(viewToOpen)) {
            PieChartController view = loader.getController();
            view.init(viewModelFactory.getPieChartViewModel(), this);
            stage.setTitle("Pie Chart");
        }
        else if ("Text".equals(viewToOpen))
        {
            TextController textController = loader.getController();
            textController.init(viewModelFactory.getTextViewModel());
            stage.setTitle("Text Chart");
        }

        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
