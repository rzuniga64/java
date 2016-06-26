package scenebuilder.datepicker;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML private DatePicker dp;
    @FXML private Label showDate;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        System.out.println("Check Box");
    }

    public void ShowDate(ActionEvent event) {

        String message = "";

        LocalDate ld = dp.getValue();
        showDate.setText(ld.toString());
    }
}
