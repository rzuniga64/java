package scenebuilder.menubar;

import java.awt.event.ActionEvent;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.MenuBar;
import javafx.scene.control.TreeView;

public class Controller implements Initializable {

    @FXML
    MenuBar menuBar;

    @Override
    public void initialize(URL location, ResourceBundle resources) { }

    public void CloseApp(ActionEvent event) {

        Platform.exit();
        System.exit(0);
    }
}
