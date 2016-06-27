package properties;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    private final MyNumber myNum = new MyNumber();

    @FXML private Label lblStatus;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        myNum.setNumber(0);
        myNum.numberProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                lblStatus.setText(new Double(myNum.getNumber()).toString());
            }
        });
    }

    // Calling setNumber does directly change the value of the Label. The value of the number is being changed using
    // the MyNumber class. When the setNumber is called an the property is changed it is going to call the listener
    // above on this property and it is going to set the Label to the number.
    public void BtnClick(ActionEvent event) {

        myNum.setNumber(myNum.getNumber() + 1);
    }
}
