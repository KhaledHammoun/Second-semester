package Ex5_2.view;

import Ex5_2.core.ViewHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class TemperatureViewController
{
   @FXML private Label outputLabel;
   @FXML private TextField filterField;
   @FXML private Label filterLabel;

   private ViewHandler viewHandler;
   private TemperatureViewModel model;
   private String thermometerId;

   public TemperatureViewController()
   {
   }

   public void init(ViewHandler viewHandler, TemperatureViewModel model)
   {
      this.viewHandler = viewHandler;
      this.model = model;
      thermometerId = null;
      outputLabel.textProperty().bind(model.temperature());
   }

   @FXML private void updateButtonPressed()
   {
      model.getLastTemp(thermometerId);
   }

   @FXML private void onFilter()
   {
      String oldValue = filterLabel.getText();
      if (oldValue.equals("All"))
      {
         oldValue = null;
      }
      if (filterField.getText() == null || filterField.getText().isBlank())
      {
         thermometerId = null;
         filterLabel.setText("All");
      }
      else
      {
         thermometerId = filterField.getText();
         filterLabel.setText(thermometerId);
      }
      filterField.setText(null);
      updateButtonPressed();
   }
}
