package client.core;

import client.util.View;
import client.view.ViewController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ViewFactory
{
    private static Map<View, Scene> scenes;
    private static Stage stage;

    static
    {
        scenes = new HashMap<>();
    }

    public static void init(Stage theStage)
    {
        stage = theStage;
        createScene(View.LOGIN);
        createScene(View.CHAT_VIEW);
        createScene(View.FRIEND);
        createScene(View.FIND_FRIEND);
    }

    private static void createScene(View sceneName)
    {
        Scene scene = null;
        switch (sceneName)
        {
            case LOGIN:
                try
                {
                    Parent root = loadFXML("../view/login/LogIn.fxml");
                    scene = new Scene(root);
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }
                break;
            case CHAT_VIEW:
                try
                {
                    Parent root = loadFXML("../view/chatview/ChatView.fxml");
                    scene = new Scene(root);

                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }
                break;
            case FRIEND:
                try
                {
                    Parent root = loadFXML("../view/friends/FriendsView.fxml");
                    scene = new Scene(root);

                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }
                break;
            case FIND_FRIEND:
                try
                {
                    Parent root = loadFXML("../view/findfriends/FindFriends.fxml");
                    scene = new Scene(root);

                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }
                break;
        }
        scenes.put(sceneName, scene);
    }

    private static Parent loadFXML(String path) throws IOException
    {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(ViewFactory.class.getResource(path));
        Parent root = loader.load();

        ViewController ctrl = loader.getController();
        ctrl.init(ViewHandler.getViewHandler(), ViewModelFactory.getViewModelFactory());
        return root;
    }

    public static Scene getScene(View sceneName)
    {
        return scenes.get(sceneName);
    }
}

