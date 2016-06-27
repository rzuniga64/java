package bidirectional_binding;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import properties_binding.MyNumber;

import java.net.URL;
import java.text.NumberFormat;
import java.util.ResourceBundle;

/**
 *  JavaFX property binding allows you to synchronize the value of two properties so that whenever one of the
 *  properties changes, the value of the other property is updated automatically.
 *      Unidirectional binding
 *      Bidirectional binding
*/
public class Controller implements Initializable {

    private final MyNumber myNum = new MyNumber();

    @FXML private Slider slider;
    @FXML private TextField field;

    private static final double INIT_VALUE = 50;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        slider.setValue(INIT_VALUE);
        field.setText(Double.toString(INIT_VALUE));
        field.textProperty().bindBidirectional(slider.valueProperty(), NumberFormat.getNumberInstance());
    }
}
