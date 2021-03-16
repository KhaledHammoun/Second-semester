package Ex12_1_Ex12_2.Client;


import Ex12_1_Ex12_2.Client.core.ClientFactory;
import Ex12_1_Ex12_2.Client.core.ModelFactory;
import Ex12_1_Ex12_2.Client.core.ViewHandler;
import Ex12_1_Ex12_2.Client.core.ViewModelFactory;
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
