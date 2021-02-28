package S03_MVVM.Ex4_7;

import S03_MVVM.Ex4_7.model.DataModelManager;
import S03_MVVM.Ex4_7.model.ModelFactory;
import S03_MVVM.Ex4_7.view.ViewHandler;
import S03_MVVM.Ex4_7.viewmodel.ViewModelFactory;
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
                    Thread.sleep(r.nextInt(500) + 5000); //Changed the sleeping time to +5 sec
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thread.setDaemon(true);
        thread.start() ;
    }
}
