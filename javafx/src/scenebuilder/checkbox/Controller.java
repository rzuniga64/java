package scenebuilder.checkbox;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.event.ActionEvent;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML private CheckBox cb1;
    @FXML private CheckBox cb2;
    @FXML private CheckBox cb3;
    @FXML private CheckBox cb4;
    @FXML private Label lbllist;
    @FXML private Label lblcount;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        System.out.println("Check Box");
    }

    public void checkEvent(ActionEvent event) {
        int count = 0;
        String message = "";

        if (cb1.isSelected()) {
            count++;
            message += cb1.getText() + "\n";
        }
        if (cb2.isSelected()) {
            count++;
            message += cb2.getText() + "\n";
        }
        if (cb3.isSelected()) {
            count++;
            message += cb3.getText() + "\n";
        }
        if (cb4.isSelected()) {
            count++;
            message += cb4.getText() + "\n";
        }

        lblcount.setText("Items selected : " + count);
        lbllist.setText(message);
    }
}
