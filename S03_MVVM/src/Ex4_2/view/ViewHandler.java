package Ex4_2.view;

import Ex4_2.viewmodel.ViewModelFactory;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ViewHandler
{
  private Stage stage;
  private Scene scene;
  private ViewModelFactory viewModelFactory;

  public ViewHandler(ViewModelFactory viewModelFactory)
  {
    this.viewModelFactory = viewModelFactory;
  }

  public void start() throws Exception
  {
    openToUppercase();
  }

  public void openToUppercase() throws IOException
  {
    FXMLLoader loader = new FXMLLoader();
    loader.setLocation(getClass().getResource("UppercaseView.fxml"));
    Parent root = null;

    root = loader.load();

    UppercaseViewController controller = loader.getController();
    controller.init(viewModelFactory.getUppercaseVM());
    scene = new Scene(root);
    stage = new Stage();
    stage.setScene(scene);
    stage.show();
  }
}
