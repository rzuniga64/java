package scenebuilder.listview;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    public ListView<String> listview;

    private ObservableList<String> list = FXCollections.observableArrayList("Mark", "Tom", "John", "Jack");

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        listview.setItems(list);
        listview.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
    }

    public void buttonAction(ActionEvent event) {

        //listview.getItems().addAll("Ben", "Steve");

        ObservableList<String> names;
        names = listview.getSelectionModel().getSelectedItems();
        for (String name : names) {
            System.out.println(name);
        }
    }
}

