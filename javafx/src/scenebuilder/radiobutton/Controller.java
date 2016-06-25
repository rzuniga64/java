package scenebuilder.radiobutton;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML private RadioButton rb1;
    @FXML private RadioButton rb2;
    @FXML private Label lbl1;

    @Override
    public void initialize(URL location, ResourceBundle resources) {}

    public void radioSelect(ActionEvent event) {
        String message = "";

        if (rb1.isSelected()) {
            message += rb1.getText() + "\n";
        }
        if (rb2.isSelected()) {
            message += rb2.getText() + "\n";
        }

        lbl1.setText(message);
    }
}