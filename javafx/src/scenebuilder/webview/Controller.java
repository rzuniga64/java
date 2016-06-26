package scenebuilder.webview;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML private WebView webview;

    private WebEngine engine;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        // load the engine for the Web View
        engine = webview.getEngine();
    }

    public void btn1(ActionEvent event) {

        engine.load("https://www.google.com");
    }

    public void btn2(ActionEvent event) {

        engine.executeScript("window.location = \"http://easyonlineconverter.com//\";");
    }

    public void btn3(ActionEvent event) {

        engine.loadContent("<html><body><h1>Hello World!</h1></body></html>");
    }

    public void btn4(ActionEvent event) {

        engine.reload();
    }
}
