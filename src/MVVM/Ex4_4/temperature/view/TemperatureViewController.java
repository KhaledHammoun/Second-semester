package MVVM.Ex4_4.temperature.view;

import MVVM.Ex4_4.temperature.core.ViewHandler;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Region;

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
