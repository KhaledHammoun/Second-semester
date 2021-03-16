package Ex4_6;

import Ex4_6.model.DataModelManager;
import Ex4_6.model.ModelFactory;
import Ex4_6.view.ViewHandler;
import Ex4_6.viewmodel.ViewModelFactory;
import javafx.application.Application;
import javafx.stage.Stage;


import java.util.Random;

public class PieChartApp extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        ModelFactory mf = new ModelFactory();
        ViewModelFactory viewModelFactory = new ViewModelFactory(mf);
        ViewHandler viewHandler = new ViewHandler(viewModelFactory);
        viewHandler.start("PieChart");

        runAutoUpdate((DataModelManager) mf.getDataModel());
    }

    private void runAutoUpdate(DataModelManager m) {
        Thread thread = new Thread(() -> {
            Random r = new Random();
            while (true) {
                m.recalculateData();
                try {
                    Thread.sleep(r.nextInt(500) + 1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thread.setDaemon(true);
        thread.start() ;
    }
}
