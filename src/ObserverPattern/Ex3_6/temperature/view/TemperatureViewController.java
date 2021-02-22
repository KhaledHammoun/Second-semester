package ObserverPattern.Ex3_6.temperature.view;

import ObserverPattern.Ex3_6.temperature.mediator.NamedPropertyChangeSubject;
import ObserverPattern.Ex3_6.temperature.mediator.TemperatureModel;
import ObserverPattern.Ex3_6.temperature.model.Temperature;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Region;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class TemperatureViewController implements PropertyChangeListener
{
   @FXML private Label outputLabel;
   @FXML private TextField filterField;
   @FXML private Label filterLabel;

   private ViewHandler viewHandler;
   private TemperatureModel model;
   private Region root;
   private String thermometerId;
   private NamedPropertyChangeSubject subject;

   public TemperatureViewController()
   {
   }

   public void init(ViewHandler viewHandler, TemperatureModel model, Region root, NamedPropertyChangeSubject subject)
   {
      this.viewHandler = viewHandler;
      this.model = model;
      this.root = root;
      thermometerId = null;
      this.subject = subject;
      subject.addListener(null,this);
   }

   public void reset()
   {
      subject.removeListener(null, this);
   }

   public Region getRoot()
   {
      return root;
   }

   @FXML private void updateButtonPressed()
   {
      /*Temperature t = model.getLastInsertedTemperature(thermometerId);
      if (t != null)
      {
         outputLabel.setText(t.toString());
      }
      else
      {
         outputLabel.setText("No data");
      }*/
   }

   @FXML private void onFilter()
   {
      String oldValue = filterLabel.getText();
      if (oldValue.equals("All"))
      {
         oldValue = null;
      }
      thermometerId = filterField.getText();
      if (thermometerId.isEmpty())
      {
         thermometerId = null;
         filterLabel.setText("All");
      }
      else
      {
         filterLabel.setText(thermometerId);
      }
      filterField.setText(null);
      updateButtonPressed();
   }

   @Override public void propertyChange(PropertyChangeEvent evt)
   {

      Platform.runLater(() ->
          outputLabel.setText(evt.getNewValue().toString())
      );
   }
}
