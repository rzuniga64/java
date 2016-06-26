package scenebuilder.combobox;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;

public class Controller implements Initializable {

    @FXML public Label myLabel;
    @FXML public ComboBox<String> combobox;

    private ObservableList<String> list = FXCollections.observableArrayList("Mark", "Tom", "John", "Jack");

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        combobox.setItems(list);
    }

    public void comboChanged(ActionEvent event) {

        myLabel.setText(combobox.getValue());
    }

    public void buttonAction(ActionEvent event) {

        combobox.getItems().addAll("Ben", "Steve");
    }
}

