package S07_MVVM_Sockets.Ex12_1_Ex12_2.Client;

import S07_MVVM_Sockets.Ex12_1_Ex12_2.Client.core.ClientFactory;
import S07_MVVM_Sockets.Ex12_1_Ex12_2.Client.core.ModelFactory;
import S07_MVVM_Sockets.Ex12_1_Ex12_2.Client.core.ViewHandler;
import S07_MVVM_Sockets.Ex12_1_Ex12_2.Client.core.ViewModelFactory;
import javafx.application.Application;
import javafx.stage.Stage;

@SuppressWarnings("ALL")
public class TimestampApp extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        ClientFactory clientFactory = new ClientFactory();
        ModelFactory mf = new ModelFactory(clientFactory);
        ViewModelFactory viewModelFactory = new ViewModelFactory(mf);
        ViewHandler viewHandler = new ViewHandler(stage, viewModelFactory);
        viewHandler.start();

    }

}
