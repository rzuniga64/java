package properties_binding;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ProgressIndicator;

import java.net.URL;
import java.util.ResourceBundle;

/**
 *  JavaFX property binding allows you to synchronize the value of two properties so that whenever one of the
 *  properties changes, the value of the other property is updated automatically.
 *      Unidirectional binding
 *      Bidirectional binding
*/
public class Controller implements Initializable {

    private final MyNumber myNum = new MyNumber();

    @FXML private Label lblStatus;
    @FXML private ProgressBar pb;
    @FXML private ProgressIndicator pi;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        myNum.setNumber(0);
        myNum.numberProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                lblStatus.setText(Double.toString(myNum.getNumber()));
            }
        });

        // Unidrectional Binding
        // bind the property of the progress bar to the property of the MyNumber class.
        pb.progressProperty().bind(myNum.numberProperty());
        pi.progressProperty().bind(myNum.numberProperty());
    }

    // Calling setNumber does directly change the value of the Label. The value of the number is being changed using
    // the MyNumber class. When the setNumber is called an the property is changed it is going to call the listener
    // above on this property and it is going to set the Label to the number.

    public void BtnClick(ActionEvent event) {

        myNum.setNumber(myNum.getNumber() + 0.1);
    }

    public void Btn2Click(ActionEvent event) {

        myNum.setNumber(myNum.getNumber() - 0.1);
    }
}
